package com.data.array.com.data.threadpool.impl;

import com.data.array.com.data.threadpool.impl.SimpleThreadPoolExecutor.DiscardException;

interface DiscardPolicy {//拒绝策略接口
    void discard() throws DiscardException;
}