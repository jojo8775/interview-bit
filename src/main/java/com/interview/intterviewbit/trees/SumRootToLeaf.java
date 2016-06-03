package com.interview.intterviewbit.trees;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf
{
	private int sum=0, mod = 1003;
	
	public int sum(TreeNode a){
		List<Integer> L = new ArrayList<Integer>();
		L.add(a.val);
		
		treePath(a, L);
		return sum;
	}
	
	private void treePath(TreeNode node, List<Integer> path){
		if(node.left == null && node.right == null){
			int temp = 0;
			for(int i=0; i<path.size(); i++){
				temp = temp*10 + path.get(i);
//				temp %= mod;
			}
			
			System.out.println(temp);
			
			sum = sum + temp;
			sum %= mod;
			return;
		}
		
		if(node.left != null){
			path.add(node.left.val);
			treePath(node.left, path);
			path.remove(path.size() - 1);
		}
		
		if(node.right != null){
			path.add(node.right.val);
			treePath(node.right, path);
			path.remove(path.size() - 1);
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
	
	public static void main(String[] args){
		int s = new SumRootToLeaf().sum(createNode());
		System.out.println(s);
	}
	
	private static TreeNode createNode(){
//		TreeNode head = new TreeNode(1), cur = head;
//		cur.left = new TreeNode(2);
//		cur.right = new TreeNode(3);
//		cur = cur.right;
//		cur.left = new TreeNode(4);
//		cur = cur.left;
//		cur.right = new TreeNode(5);
		
		TreeNode head = new TreeNode(1), cur = head;
		cur.right = new TreeNode(2);
		
		return head;
	}
}
