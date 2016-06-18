package com.interview.intterviewbit.graph;

/*-
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3
 * @author jojo
 *
 */
public class ConvertListToBST
{
	public TreeNode sortedListToBST(ListNode a) {
	    return createTree(a);
	}
	
	private TreeNode createTree(ListNode node){
	    if(node == null){
	        return null;
	    }
	    
	    ListNode sn = node, fn = node, pn = null;
	    while(fn.next != null){
	        pn = sn;
	        sn = sn.next;
	        fn = fn.next;
	        if(fn.next != null){
	            fn = fn.next;
	        }
	    }
	    
	    TreeNode tn = new TreeNode(sn.val);
	    if(pn != null){
	        pn.next = null;
    	    tn.left = createTree(node);
	    }
	    tn.right = createTree(sn.next);
	    
	    return tn;
	}
	
	 private static class ListNode {
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }
	 
	 private static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
