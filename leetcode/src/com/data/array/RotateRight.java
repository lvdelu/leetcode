package com.data.array;

import com.data.node.ListNode;

public class RotateRight {
	// 1->2->3->4->5->NULL, k = 2
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || k < 0) {
			return null;
		}
		// 遍历获得链表长度大小
		int length = 0;
		ListNode temp = head;

		while (temp != null) {
			length++;
			temp = temp.next;
		}
		k = k % length;
		if (k == 0) {
			return head;
		}

		int i = 0, j = length - k;
		ListNode nodeK = null;
		ListNode tem = head;
		ListNode tem2 = null;
		while (tem != null) {
			if (i < j) {
				tem2 = tem;
				tem = tem.next;
				i++;
			} else {
				nodeK = tem;
				break;
			}
		}

		ListNode h = nodeK;
		while (h.next != null) {
			h = h.next;
		}
		h.next = head;
		tem2.next = null;
		return nodeK;
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

		RotateRight rr = new RotateRight();

		ListNode listNode = rr.rotateRight(list1, 5);

		System.out.println();

		print(listNode);

	}

	private static void print(ListNode list1) {
		ListNode temp = list1;

		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}