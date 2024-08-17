package com.dsa.fastandslowpointers;

public class ListCycleLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isCyclicList(ListNode head) {
		// initialize two pointers at the beginning of the list
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null & fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				cycleLength(slow);

		}
		return false;

	}
	
	public static int cycleLength(ListNode slow)
	{
		ListNode current=slow;
		int cycleLength=0;
		do
		{
			current=current.next;
			cycleLength++;
		}while(current!=slow);
			
			return cycleLength;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

}












