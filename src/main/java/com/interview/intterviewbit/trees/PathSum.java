package com.interview.intterviewbit.trees;

public class PathSum
{
	public boolean sol(TreeNode node, int sum){
		if(node == null){
			return sum == 0;
		}
		
		return hasPath(node, sum);
	}
	
	private boolean hasPath(TreeNode node, int sum){
		int temp = sum - node.val;
		
		if(temp == 0 && node.left == null && node.right == null){
			return true;
		}
		
		boolean status = false;
		
		if(node.left != null){
			status = status || hasPath(node.left, temp);
		}
		
		if(node.right != null){
			status = status || hasPath(node.right, temp);
		}
		
		return status;
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
