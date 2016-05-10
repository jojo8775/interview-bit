package com.interview.intterviewbit.random;

public class MergeSortedList
{
	public Node merge(Node a, Node b){
		if(a == b && b == null){
			return b;
		}
		
		Node temp = new Node();
		Node tempHead = temp;

		while(true){
			if(a == null){
				temp.next = b;
				break;
			}
			else if(b==null){
				temp.next = a;
				break;
			}
			else if(a.val < b.val){
				temp.next = a;
				a = a.next;
				temp = temp.next;
			}
			else{
				temp.next = b;
				b = b.next;
				temp = temp.next;
			}
		}
		
		return tempHead.next;
	}
	
	public static void main(String[] args){
		Node a = createList(2,3,20);
		Node b = createList(5,10,15);
		Node r = new MergeSortedList().merge(a, b);
		print(r);
	}
	
	private static Node createList(int... a){
		Node head = new Node(), cur = head;
		for(int i : a){
			Node n = new Node();
			n.val = i;
			cur.next = n;
			cur = cur.next;
		}
		
		return head.next;
	}
	
	private static void print(Node n){
		while(n != null){
			System.out.print(n.val + " -> ");
			n = n.next;
		}
	}
	
	private static class Node
	{
		public int val;
		public Node next;
		@Override
		public String toString()
		{
			return "Node [val=" + val + ", next=" + next + "]";
		}
	}
}
