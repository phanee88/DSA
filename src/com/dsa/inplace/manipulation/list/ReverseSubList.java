package com.dsa.inplace.manipulation.list;

import com.dsa.utils.ListNode;

public class ReverseSubList {

	public static void main(String[] args) {
		 ListNode head = new ListNode(1);
	        head.next = new ListNode(2);
	        head.next.next = new ListNode(3);
	        head.next.next.next = new ListNode(4);
	        head.next.next.next.next = new ListNode(5);
			/*
			 * ListNode result=reverse(head);
			 * 
			 * while(result!= null) { System.out.println(result.getVal()+"");
			 * result=result.next; }
			 */
		
	}

	public static ListNode reverseKNodes(ListNode head,int k)
	{
		if (head == null)
			return null;
		
		ListNode prev=null;
		ListNode curr=head;
		ListNode nextTemp=null;
		
		int i=0;
		
		while(i<=k ) {
			 nextTemp=curr.next;
			curr.next=prev;//reverse the current node
			prev=curr;
			curr=nextTemp;
			i++;
		}
		
		//after the loop current will be pointing to null and prev will be pointing to new head
		return prev;

	}
	
	
}
