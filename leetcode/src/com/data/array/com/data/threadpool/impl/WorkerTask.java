package com.data.array.com.data.threadpool.impl;

public static class WorkerTask extends Thread {
    // 线程状态
    private TaskState taskState;
    // 线程编号
    private static int threadInitNumber;
    /**
     * 生成线程名,参考Thread.nextThreadNum();
     *
     * @return
     */
    private static synchronized String nextThreadName() {
        return THREAD_NAME_PREFIX + (++threadInitNumber);
    }

    WorkerTask() {
        super(THREAD_GROUP, nextThreadName());
    }

    @Override
    public void run() {
        Runnable target;
        //说明该线程处于空闲状态
        OUTER:
        while (this.taskState != TaskState.TERMINATED) {
            synchronized (TASK_QUEUE) {
                while (this.taskState == TaskState.FREE && TASK_QUEUE.isEmpty()) {
                    try {
                        this.taskState = TaskState.BLOCKED;//此处标记
                        //没有任务就wait住,让出CPU执行权
                        TASK_QUEUE.wait();
                        //如果被打断说明当前线程执行了 shutdown() 方法  线程状态为 TERMINATED 直接跳到 while 便于退出
                    } catch (InterruptedException e) {
                        break OUTER;
                    }
                }
                target = TASK_QUEUE.removeFirst();//遵循FIFO策略
            }
            if (target != null) {
                this.taskState = TaskState.RUNNABLE;
                target.run();//开始任务了
                this.taskState = TaskState.FREE;
            }
        }
    }

    void close() {//优雅关闭线程
        this.taskState = TaskState.TERMINATED;
        this.interrupt();
    }

    private enum TaskState {
        FREE, RUNNABLE, BLOCKED, TERMINATED;
    }
}
