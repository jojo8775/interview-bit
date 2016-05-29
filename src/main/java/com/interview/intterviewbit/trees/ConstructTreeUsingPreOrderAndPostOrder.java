package com.interview.intterviewbit.trees;

import java.util.Arrays;
import java.util.List;

public class ConstructTreeUsingPreOrderAndPostOrder
{
	public TreeNode createTreeNode(List<Integer> pre, List<Integer> post)
	{
		TreeNode node = createNode(pre, post, 0, post.size() - 1);

		return node;
	}

	private TreeNode createNode(List<Integer> pre, List<Integer> post, int beg, int end)
	{
		if (beg == end)
		{
			return new TreeNode(post.get(end));
		}

		// find end val index in pre
		int currentRootIndex = -1;
		for (int i = 0; i <= end; i++)
		{
			if (pre.get(i) == post.get(end))
			{
				currentRootIndex = i;
				break;
			}
		}

		int leftChildIdx = -1;

		for (int i = beg; i < end; i++)
		{
			if (pre.get(currentRootIndex + 1) == post.get(i))
			{
				leftChildIdx = i;
				break;
			}
		}

		TreeNode currentRootNode = new TreeNode(post.get(end));
		currentRootNode.left = createNode(pre, post, beg, leftChildIdx);
		currentRootNode.right = createNode(pre, post, leftChildIdx + 1, end - 1);

		return currentRootNode;
	}

	private static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val)
		{
			this.val = val;
		}

		@Override
		public String toString()
		{
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}

	public static void main(String[] args)
	{
		TreeNode node = new ConstructTreeUsingPreOrderAndPostOrder()
				.createTreeNode(Arrays.asList(1, 2, 4, 8, 9, 5, 3, 6, 7), Arrays.asList(8, 9, 4, 5, 2, 6, 7, 3, 1));
	}
}
