package com.interview.intterviewbit.linkedlist;

public class RemoveDuplicateFromSortedListII
{
	public ListNode deleteDuplicates(ListNode a)
	{
		if(a == null || a.next == null){
	        return a;
	    }
	    
	    ListNode temp = a, cur = a.next, prev = null, head = null;
	    boolean stale = false;
	    
	    while(cur != null){
	       if(cur.val != temp.val){
	            if(stale){
	                stale = false;
	            }
	            else{
    	            if(head == null){
    	                head = temp;
    	                prev = temp;
    	            }
    	            else{
        	            prev.next = temp;
        	            prev = temp;
    	            }
	            }
	            
                temp = cur;
	        }
	        else {
	            stale = true;
	        }
	        cur = cur.next;
	    }
	    
	    temp.next = null;
	    
	    if(!stale){
    	    if(head == null){
    	        head = temp;
    	    }
    	    else{
    	        prev.next = temp;
    	    }
	    }
	    else if(head != null){
	    	prev.next = null;
	    }
	    
	    return head;
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
		ListNode node = new ListNode(1);
		ListNode head = node;
		node.next = new ListNode(1);
		node = node.next;
		node.next = new ListNode(3);
		node = node.next;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(2);

		new RemoveDuplicateFromSortedListII().deleteDuplicates(head);
	}
}
