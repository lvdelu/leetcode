package com.data.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Graph {

	private static int v;// 个数

	private static LinkedList<Integer>[] adj;// 邻接表

	public Graph(int v) {

		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	// 无向图一条边存储两次
	public void addEdge(int s, int t) {
		adj[s].add(t);
		adj[t].add(s);
	}

	public int getV() {
		return v;
	}

	public LinkedList<Integer>[] getAdj() {
		return adj;
	}

	private static void reCurDfs(int s, int t, Boolean[] visited, int[] pre, boolean found) {
		if (found) {
			return;
		}

		visited[s] = true;

		for (int i = 0; i < adj[s].size(); i++) {
			int node = adj[s].get(i);
			if (!visited[node]) {
				pre[node] = s;
				if (s == t) {
					found = true;
					return;
				}
				reCurDfs(node, t, visited, pre, found);
			}
		}

	}

	public static void main(String[] args) {
		/*
		 * 无向图表示
		 * 
		 * 1 2 3
		 * 
		 * 4 5 6
		 * 
		 * 	 7 8
		 */
		Graph graph = new Graph(10);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(3, 6);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);

		// 无向图遍历

		// bfs遍历
		Graph.bfs(1, 8);
		System.out.println();
		// dfs遍历
		 Graph.dfs(1, 8);// 输出最短路径
		//

	}

	private static boolean found = false;

	private static void dfs(int s, int t) {

		boolean[] visited = new boolean[v];

		int[] pre = new int[v];

		for (int i = 0; i < v; i++) {
			visited[i] = false;
			pre[i] = -1;
		}

		recurDfs(s, t, visited, pre);

		print(s, t, pre);
	}

	private static void print(int s, int t, int[] pre) {
		if (s != t && pre[t] != -1) {
			print(s, pre[t], pre);
		}
		System.out.print(t + " ");

	}

	private static void recurDfs(int s, int t, boolean[] visited, int[] pre) {

		if (found) {
			return;
		}

		visited[s] = true;

		for (int i = 0; i < adj[s].size(); ++i) {
			int node = adj[s].get(i);
			if (!visited[node]) {
				pre[node] = s;

				if (s == t) {
					return;
				}
				recurDfs(node, t, visited, pre);
			}
		}

	}

	private static void bfs(int s, int t) {

		boolean[] visited = new boolean[v];

		int[] pre = new int[v];

		for (int i = 0; i < v; i++) {
			visited[i] = false;
			pre[i] = -1;
		}
		Queue<Integer> queue = new ArrayBlockingQueue<>(v);
		queue.add(s);
		visited[s] = true;
		while (!queue.isEmpty()) {
			int node=queue.poll();
			for (int i = 0; i < adj[node].size(); ++i) {
				int w = adj[node].get(i);
				if (!visited[w]) {
					visited[w] = true;
					pre[w] = node;
					if (w == t) {
						print(s, t, pre);
						return;
					}
					queue.add(w);
				}

			}
		}
	}

}
