package com.interview.intterviewbit.linkedlist;

public class DetectLoop
{
	public ListNode detectCycle(ListNode a) {
	    if(a == null || a.next == null){
	        return null;
	    }
	    
	    ListNode f = a.next.next, s = a.next;
	    
	    while(f!=null){
	        if(f == s){
	            break;
	        }
	        
	        s=s.next;
	        f = f.next;
	        if(f!=null){
	            f = f.next;
	        }
	    }
	    
	    if(f==null){
	        return null;
	    }
	    
	    if(s==f){
	        s = a;
	    }
	    
	    while(s.val != f.val){
	        s = s.next;
	        f = f.next;
	    }
	    
	    return f;
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
