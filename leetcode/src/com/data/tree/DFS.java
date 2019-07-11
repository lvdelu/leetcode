package com.data.tree;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class DFS {

	public static int[] array = { 0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0 };

	// 构建DFS
	public static Node tree(int[] array, int index) {

		if (index < array.length) {
			int value = array[index];
			if (value != 0) {
				Node node = new Node(array[index]);
				node.setLeft(tree(array, 2 * index));
				node.setRight(tree(array, 2 * index + 1));
				return node;
			}
		}

		return null;

	}

	// BFS遍历,广度优先遍历
	public static void bfsTravel(Queue<Node> queue) {

		if (queue.isEmpty()) {
			return;
		}

		Node node = queue.poll();

		System.out.print(node.getValue() + " ");

		if (node.getLeft() != null) {
			queue.add(node.getLeft());
		}
		if (node.getRight() != null) {
			queue.add(node.getRight());
		}

		bfsTravel(queue);

	}

	//DFS深度优先遍历
	public static void bfstravel(Node node) {

		if (node != null) {
			System.out.print(node.getValue() + " ");
		}
		if (node.getLeft() != null) {
			bfstravel(node.getLeft());
		}

		if (node.getRight() != null) {
			bfstravel(node.getRight());
		}

	}

	public static void main(String[] args) {

		Node node = tree(array, 1);// 给数组多添加一位
		Queue<Node> queue = new ArrayBlockingQueue<>(array.length);
		queue.add(node);// DFS 按照层次遍历
		bfsTravel(queue);
		System.out.println();
		bfstravel(node);

	}
}
