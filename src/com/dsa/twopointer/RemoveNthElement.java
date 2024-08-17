package com.dsa.twopointer;

public class RemoveNthElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * RemoveNthElement obj= new RemoveNthElement();
		 * 
		 * ListNode head = new ListNode(1); head.next = new ListNode(2); head.next.next
		 * = new ListNode(3); head.next.next.next = new ListNode(4);
		 * head.next.next.next.next = new ListNode(5); obj.removeNthFromEnd(head,3);
		 */

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		//initialize two pointers at the begining of the list
		ListNode left = head;
		ListNode right = head;
		//move right pointer to n el
		
		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		//check  we are already at end of the list 
		if (right == null) {
			return head;
		}
		//move right and left pointers one step each time
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}

		left = left.next.next;

		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
