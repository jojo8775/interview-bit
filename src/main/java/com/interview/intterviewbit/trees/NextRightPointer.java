package com.interview.intterviewbit.trees;

public class NextRightPointer
{
	public void connect(TreeLinkNode root){
		while(root != null){
			TreeLinkNode firstNode = new TreeLinkNode(0), prev = firstNode;
			
			for(TreeLinkNode current = root; current != null; current = current.next){
				if(current.left != null){
					prev.next = current.left;
					prev = current.left;
				}
				
				if(current.right != null){
					prev.next = current.right;
					prev = current.right;
				}
			}
			
			root = firstNode.next;
		}
	}
	
	public class TreeLinkNode
	{
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x)
		{
			val = x;
		}

		@Override
		public String toString()
		{
			return "TreeLinkNode [val=" + val + ", left=" + left + ", right=" + right + ", next=" + next + "]";
		}
	}
}
