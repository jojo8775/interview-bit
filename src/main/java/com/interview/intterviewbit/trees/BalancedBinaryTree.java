package com.interview.intterviewbit.trees;

public class BalancedBinaryTree
{
	public boolean isTreeBalanced(TreeNode node)
	{
		return isBalanced(node);
	}

	private boolean isBalanced(TreeNode node)
	{
		if (node == null)
		{
			return true;
		}

		int leftHeight = findHeight(node.leftChild), rightHeight = findHeight(node.rightChild);

		if (Math.abs(leftHeight - rightHeight) < 2 && isBalanced(node.rightChild) && isBalanced(node.rightChild))
		{
			return true;
		}

		return false;
	}

	private int findHeight(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}

		return 1 + Math.max(findHeight(node.leftChild), findHeight(node.rightChild));
	}

	private static class TreeNode
	{
		int val;
		TreeNode leftChild;
		TreeNode rightChild;

		public TreeNode(int val)
		{
			this.val = val;
		}
	}
}
