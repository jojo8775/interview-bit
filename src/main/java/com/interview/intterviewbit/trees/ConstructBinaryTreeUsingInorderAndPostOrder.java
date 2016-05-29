package com.interview.intterviewbit.trees;

import java.util.Arrays;
import java.util.List;

public class ConstructBinaryTreeUsingInorderAndPostOrder
{
	public TreeNode create(List<Integer> in, List<Integer> post)
	{
		TreeNode node = create(in, post, 0, post.size() - 1, 0, post.size() - 1);
		return node;
	}

	private TreeNode create(List<Integer> in, List<Integer> post, int beg, int end, int posB, int posE)
	{
		if (beg > end || posB > posE)
		{
			return null;
		}
		
		if(beg == end){
			return new TreeNode(post.get(posB));
		}

		TreeNode curRoot = new TreeNode(post.get(posE));

		int idx = -1;
		for (int i = beg; i <= end; i++)
		{
			if (post.get(posE) == in.get(i))
			{
				idx = i;
				break;
			}
		}

		curRoot.left = create(in, post, beg, idx - 1, posB, posB + idx - 1 - beg);
		curRoot.right = create(in, post, idx + 1, end, posB + idx - beg, posE - 1);

		return curRoot;
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
		TreeNode node = new ConstructBinaryTreeUsingInorderAndPostOrder().create(Arrays.asList(4, 2, 5, 1, 6, 7, 3, 8),
				Arrays.asList(4, 5, 2, 6, 7, 8, 3, 1));
		
		preOrder(node);
	}
	
	private static void preOrder(TreeNode node){
		if(node == null){
			return;
		}
		
		System.out.print(node.val + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}
}
