package com.interview.intterviewbit.trees;

public class InvertBT
{
	public TreeNode invert(TreeNode root){
		TreeNode node = root;
		invertChild(root);
		return node;
	}
	
	private void invertChild(TreeNode node){
		if(node == null){
			return;
		}
		
		TreeNode lc = node.left;
		TreeNode rc = node.right;
		node.right = lc;
		node.left = rc;
		invertChild(node.left);
		invertChild(node.right);
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
