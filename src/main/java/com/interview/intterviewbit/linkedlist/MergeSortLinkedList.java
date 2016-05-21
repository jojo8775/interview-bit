package com.interview.intterviewbit.linkedlist;

public class MergeSortLinkedList
{
	public ListNode mergeSort(ListNode n){
		if(n==null || n.next == null){
			return n;
		}
		
		ListNode l1 = n, head = l1;
		
		//finding list size
		int count=0;
		while(l1 != null){
			count++;
			l1 = l1.next;
		}
		
		l1 = head;
		int middle = count/2;
		
		//splitting list
		ListNode left = head, right = null;
		int halfCount = 0;
		
		while(l1!=null){
			halfCount++;
			ListNode next = l1.next;
			if(halfCount == middle){
				right = next;
				l1.next = null;
				break;
			}
			l1 = l1.next;
		}
		
		ListNode h1 = mergeSort(left);
		ListNode h2 = mergeSort(right);
		
		printList(h1);
		System.out.print("    ");
		printList(h2);
		System.out.println();
		
		return merge(h1, h2);
	}
	
	private ListNode merge(ListNode l, ListNode r){
		ListNode head = new ListNode(0), cur = head;
		
		while(l!=null || r!=null){
			if(l == null){
				cur.next = new ListNode(r.val);
				cur = cur.next;
				r = r.next;
			}
			else if(r==null){
				cur.next = new ListNode(l.val);
				cur = cur.next;
				l = l.next;
			}
			else {
				if(l.val < r.val){
					cur.next = new ListNode(l.val);
					cur = cur.next;
					l = l.next;
				}
				else if(l.val > r.val){
					cur.next = new ListNode(r.val);
					cur = cur.next;
					r = r.next;
				}
				else{
					cur.next = new ListNode(r.val);
					cur = cur.next;
					cur.next = new ListNode(l.val);
					cur = cur.next;
					
					r = r.next;
					l = l.next;
				}
			}
		}
		
		return head.next;
	}
	
	public static void main(String[] args){
//		ListNode r = new MergeSortLinkedList().mergeSort(createListNode(8,5,4,3,1));
		ListNode r = new MergeSortLinkedList().mergeSort(createListNode(4,19,14,5,-3,1,8,5,11,15));
		printList(r);
	}
	
	private static ListNode printList(ListNode l){
		ListNode head = l;
		while(l!=null){
			System.out.print(l.val + ", ");
			l = l.next;
		}
		
		return head;
	}
	
	private static ListNode createListNode(int ...args){
		ListNode head = new ListNode(0), cur = head;
		
		for(int i : args){
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		
		return head.next;
	}
	
	private static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int val){
			this.val = val;
		}
		
		@Override
		public String toString()
		{
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}
}
