package com.interview.intterviewbit.linkedlist;

public class PalindromList
{
	public int isPalindrom(ListNode a){
		if(a==null){
			return 1;
		}
		
		ListNode n1 = a, mid = null, n2 = a;
		
		while(n2.next!=null){
			n2 = n2.next;
			if(n2.next ==null){
				mid = n1.next;
				n1.next = null;
			}
			else{
				n2 = n2.next;
				n1 = n1.next;
			}
		}
		
		if(mid == null){
			mid = new ListNode(n1.val);
			mid.next = n1.next;
			n1.next = null;
		}
		
		ListNode cur = mid, next = null, prev = null;
		while(cur != null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		
		mid = prev;
		
		while(mid != null && a!=null){
			if(mid.val != a.val){
				return 0;
			}
			
			mid = mid.next;
			a = a.next;
		}
		
		return 1;
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

	public static void main(String[] args)
	{
		ListNode node = new ListNode(2);
		ListNode head = node;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(3);
		node = node.next;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(2);

		int r = new PalindromList().isPalindrom(head);
		System.out.println(r);
	}
}
