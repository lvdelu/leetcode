package com.data.array;

import com.data.node.ListNode;
/*
 * 翻转链表
 */
public class ReverseNode {

	public ListNode reversNode(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode currentNode = head;
		ListNode h = null;
		ListNode next = head.next;
		while (next != null) {
			currentNode.next = h;
			h = currentNode;
			currentNode = next;
			next = next.next;
		}
		
		currentNode.next=h;

		return currentNode;
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		ListNode list5 = new ListNode(5);

		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		list5.next = null;

		print(list1);

		System.out.println();
		ReverseNode rn = new ReverseNode();

		ListNode node = rn.reversNode(list1);

		print(node);

	}

	private static void print(ListNode list1) {
		ListNode temp = list1;

		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}
