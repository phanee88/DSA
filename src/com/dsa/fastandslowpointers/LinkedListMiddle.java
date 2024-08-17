package com.dsa.fastandslowpointers;

import com.dsa.utils.LinkedListUtils;
import com.dsa.utils.ListNode;

public class LinkedListMiddle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] values = { 1, 2, 3, 4, 5 ,6};
		ListNode list = LinkedListUtils.createLinkedList(values);

		ListNode middleNode=fetchMiddleNode(list);
		System.out.println(middleNode.getVal());

	}

	public static ListNode fetchMiddleNode(ListNode head) {
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

		}
		return slow;

	}

}
