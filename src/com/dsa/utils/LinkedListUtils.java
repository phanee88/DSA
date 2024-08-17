 package com.dsa.utils;


public class LinkedListUtils {
	
	public static ListNode createLinkedList(int [] values)
	{
		
		if(values.length==0)
		return null;
		
		ListNode head=new ListNode(values[0]);
		ListNode current=head;
		
		for(int i=0;i<values.length;i++) {
			
			current.next=new ListNode(values[i]);
			current=current.next;
			
		}
		return head;
	}

}
