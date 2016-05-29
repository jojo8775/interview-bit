package com.interview.intterviewbit.trees;

import java.util.Stack;

public class RecoverBST
{
	public void recover(TreeNode root){
		TreeNode current = root, prev = null, node1 = null, node2 = null;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		populate(stack, current);
		
		while(!stack.isEmpty()){
			current = stack.peek();
			populate(stack, stack.pop().right);
			
			if(prev != null){
				if(node1 == null){
					if(prev.val > current.val){
						node1 = prev;
					}
				}
				else if(current.val > node1.val){
					node2 = prev;
					break;
				}
				
			}
			
			prev = current;
		}
		
		if(node2 == null){
			node2 = current;
		}
		
		swap(node1, node2);
	}
	
	private void swap(TreeNode node1, TreeNode node2){
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
	}
	
	private void populate(Stack<TreeNode> st, TreeNode node){
		while(node != null){
			st.push(node);
			node = node.left;
		}
	}
	
	private static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x)
		{
			val = x;
		}

		@Override
		public String toString()
		{
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}
}
