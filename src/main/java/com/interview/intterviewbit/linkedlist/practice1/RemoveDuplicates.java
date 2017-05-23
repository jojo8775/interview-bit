package com.interview.intterviewbit.linkedlist.practice1;

public class RemoveDuplicates {
    public ListNode removeDuplicates(ListNode node){
        if(node == null){
            return node;
        }
        
        ListNode r = node, c = r, p = r;
        
        while(c!=null){
            if(p.val != c.val){
                p.next = c;
                p = p.next;
            }
            
            c = c.next;
        }
        
        p.next = c;
        
        return r;
    }
    
    private static class ListNode{
        ListNode next = null;
        int val;
        
        ListNode(int val){
            this.val = val;
        }
    }
    
    public static void main(String[] args){
        ListNode result = new RemoveDuplicates().removeDuplicates(createListNode(9));
        while(result != null){
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
    
    private static ListNode createListNode(int ... vals){
        ListNode node = new ListNode(0), c = node;
        for(int n : vals){
            c.next = new ListNode(n);
            c = c.next;
        }
        
        return node.next;
    }
}
