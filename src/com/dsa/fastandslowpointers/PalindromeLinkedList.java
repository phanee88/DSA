package com.dsa.fastandslowpointers;

import com.dsa.utils.LinkedListUtils;
import com.dsa.utils.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] values = { 1, 2, 3, 3, 2, 1 };
		ListNode list = LinkedListUtils.createLinkedList(values);
		Boolean isPalindrome = isPalindrome(list);
		System.out.println(isPalindrome);

	}

	public static Boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null)
			return true;

		ListNode slow = head;
		ListNode fast = head;

		// By the time fast pointer reaches the end , slow pointer will be at the middle
		// of the list
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// once we reach middle reverse the second half of the list

		ListNode headSecondHalf = reverse(slow);

		ListNode copyHeadSecondHalf = headSecondHalf;

		boolean check = compareSubList(head, headSecondHalf);

		reverse(copyHeadSecondHalf);
		if (check) {
			return true;
		}

		return false;

	}

	private static Boolean compareSubList(ListNode head, ListNode headSecondHalf) {
		while (head != null && headSecondHalf != null) {
			if (head.val != headSecondHalf.val)
				return false;
			else {
				head = head.next;
				headSecondHalf = headSecondHalf.next;
			}
		}
		return true;

	}

	public static ListNode reverse(ListNode head) {

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}
		head = prev;

		return head;

	}

}
