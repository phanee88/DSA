package com.dsa.fastandslowpointers;

public class ListCycleDetector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isCyclicList(ListNode head) {
		// initialize two pointers at the beginning of the list
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;

		}
		return false;

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

}












