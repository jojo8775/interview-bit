package com.interview.intterviewbit.linkedlist;

public class AddNumbersInAList
{
	public ListNode addNumbers(ListNode a, ListNode b){
		int carry = 0;
		ListNode head = new ListNode(0), l = head;
		
		while(a!=null && b!=null){
			int s = a.val + b.val + carry;
			carry = s/10;
			l.next = new ListNode(s%10);
			l = l.next;
			a = a.next;
			b = b.next;
		}
		
		if(a==null){
			populateRemaining(l,b,carry);
		}
		else{
			populateRemaining(l,a,carry);
		}
		
		return head.next;
	}
	
	private void populateRemaining(ListNode l, ListNode x, int carry){
		while(x != null){
			if(carry == 0){
				l.next = x;
				break;
			}
			else{
				int s = x.val + carry;
				l.next = new ListNode(s%10);
				l = l.next;
				x = x.next;
				carry = s/10;
			}
		}
		
		if(carry != 0){
			l.next = new ListNode(carry);
		}
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
	
	public static void main(String[] args){
		ListNode l1 = createList(1);
		ListNode l2 = createList(9,9,9);
		
		ListNode r = new AddNumbersInAList().addNumbers(l1, l2);
	}
	
	private static ListNode createList(int ... n){
		ListNode head = new ListNode(n[0]), l = head;
		
		for(int i=1; i<n.length; i++){
			l.next = new ListNode(n[i]);
			l = l.next;
		}
		
		return head;
	}
}
