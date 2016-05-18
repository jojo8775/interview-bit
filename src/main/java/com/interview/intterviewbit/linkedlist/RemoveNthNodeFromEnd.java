package com.interview.intterviewbit.linkedlist;

public class RemoveNthNodeFromEnd
{
	public ListNode removeNthNode(ListNode n, int b){
		if(b < 1 || n ==null){
			return n;
		}
		
		int count =0;
		ListNode l1 = n, l2 = n;
		
		while(l1 != null){
			l1 = l1.next;
			count ++;
		}
		
		b %= count;
		
		l1 = n;
		if(b == count){
			return l1.next;
		}
		
		while(l2 != null){
			if(b < 0){
				l1 = l1.next;
			}
			
			b--;
			l2 = l2.next;
		}
		
		l1.next = l1.next.next;
		
		return n;
	}
	
	private static class ListNode
	{
		public int val;
		public ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}

		@Override
		public String toString()
		{
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}
}
