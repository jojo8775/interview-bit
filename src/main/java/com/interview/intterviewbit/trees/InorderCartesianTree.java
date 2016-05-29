package com.interview.intterviewbit.trees;

import java.util.ArrayList;

public class InorderCartesianTree
{
	public TreeNode buildTree(ArrayList<Integer> a)
	{
		TreeNode root = create(a, 0, a.size() - 1);
		return root;
	}

	private TreeNode create(ArrayList<Integer> a, int beg, int end)
	{
		if (beg > end)
		{
			return null;
		}

		int maxIndex = beg, max = a.get(beg);
		for (int i = beg + 1; i <= end; i++)
		{
			if (max < a.get(i))
			{
				max = a.get(i);
				maxIndex = i;
			}
		}

		TreeNode node = new TreeNode(a.get(maxIndex));
		node.left = create(a, beg, maxIndex - 1);
		node.right = create(a, maxIndex + 1, end);

		return node;
	}

	private static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}
}
