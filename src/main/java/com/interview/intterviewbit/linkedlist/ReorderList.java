package com.interview.intterviewbit.linkedlist;

public class ReorderList
{
	private ListNode reOrder(ListNode l){
		ListNode h = l, cur = l, nxt = l.next;
		
		while(nxt != null){
			if(nxt.next != null){
				ListNode t = getTail(nxt);
				cur.next = t;
				t.next = nxt;
			}
			cur = nxt;
			nxt = nxt.next;
		}
		
		return h;
	}
	
	private ListNode getTail(ListNode n){
		if(n == null || n.next == null){
			return n;
		}
		ListNode tn = n;
		while(n.next != null){
			tn = n;
			n = n.next;
		}
		
		tn.next = null;
		return n;
	}
	
	/**
	 * Enhanced version (O)nlogn
	 */
	public ListNode reOrderList_2(ListNode n){
		if(n == null || n.next == null){
			return n;
		}
		
		ListNode head = n, fasterNode = n, slowerNode = n, middle = null;
		boolean even = false;
		
		while(fasterNode.next != null){
			fasterNode = fasterNode.next;
			if(fasterNode.next == null){
				even = true;
				break;
			}
			
			fasterNode = fasterNode.next;
			slowerNode = slowerNode.next;
		}
		
		middle = slowerNode;
		ListNode left = head, right = middle.next;
		middle.next = null;
		
		//reverse right
		right = reverseList(right);
		
		//merge
		return merge(left,right,even, middle);
	}
	
	private ListNode reverseList(ListNode n){
		ListNode prev = null, cur = n, nxt = null;
		while(cur != null){
			nxt = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nxt;
		}
		
		return prev;
	}
	
	private ListNode merge(ListNode l, ListNode r, boolean even, ListNode middle){
		ListNode mergedList = new ListNode(0), h = mergedList;
		
		while(l != null && r != null){
			mergedList.next = l;
			l = l.next;
			mergedList = mergedList.next;
			
			mergedList.next = r;
			r = r.next;
			mergedList = mergedList.next;
		}
		
		if(!even){
			mergedList.next = middle;
			mergedList = mergedList.next;
		}
		
		mergedList.next = null;
		
		return h.next;
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
//		ListNode r = new ReorderList().reOrder(createList(1, 2));
//		print(r);
		
		ListNode r = new ReorderList().reOrderList_2(createList(1,2,3,4));
		print(r);
	}
	
	private static ListNode createList(int ... arg){
		ListNode l = new ListNode(0), h = l;
		
		for(int i : arg){
			l.next = new ListNode(i);
			l = l.next;
		}
		
		return h.next;
	}

	private static void print(ListNode l){
		while(l != null){
			System.out.print(l.val + ", ");
			l = l.next;
		}
	}
}
