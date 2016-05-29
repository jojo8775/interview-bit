package com.interview.intterviewbit.trees;

import java.util.Stack;

public class TwoSumBinaryTree
{
	public boolean check(int k, TreeNode node){
		Stack<TreeNode> ls = new Stack<TreeNode>();
		Stack<TreeNode> rs = new Stack<TreeNode>();
		
		TreeNode curNode = node;
		populateLeftStack(ls, curNode);
		
		curNode = node;
		populateRightStack(rs, curNode);
		
		while(!ls.isEmpty() && !rs.isEmpty()){
			TreeNode ln = ls.peek();
			TreeNode rn = rs.peek();
			
			if(ln.val != rn.val){
				if(ln.val + rn.val < k){
					populateLeftStack(ls, ls.pop().right);
				}
				else if(ln.val + rn.val > k){
					populateRightStack(rs, rs.pop().left);
				}
				else{
					return true;
				}
			}
			else{
				// this will happen if stack are overlapping
				return false;
			}
		}
		
		return false;
	}
	
	private void populateLeftStack(Stack<TreeNode> ls, TreeNode curNode){
		while(curNode != null){
			ls.push(curNode);
			curNode = curNode.left;
		}
	}
	
	private void populateRightStack(Stack<TreeNode> rs, TreeNode curNode){
		while(curNode != null){
			rs.push(curNode);
			curNode = curNode.right;
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
