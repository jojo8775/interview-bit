package com.interview.intterviewbit.recursion;

public class ReverseLinkedList
{
	public ListNode reverse(ListNode l)
	{
		if(l.next == null){
			ListNode h = l;
			h.next = null;
			return h;
		}
		
		ListNode cur = l, nxt = l.next;
		
		ListNode h = reverse(l.next);
		nxt.next = cur;
		cur.next = null;
		return h;
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
	
	public static void main(String[] arg){
		ListNode r = new ReverseLinkedList().reverse(createList(1,2,3,4));
		print(r);
	}
	
	private static ListNode createList(int ...args){
		ListNode h = new ListNode(0), n = h;
		
		for(int i : args){
			n.next = new ListNode(i);
			n = n.next;
		}
		
		return h.next;
	}
	
	private static void print(ListNode l){
		while (l!=null)
		{
			System.out.print(l.val + ", ");
			l = l.next;
		}
	}
}
