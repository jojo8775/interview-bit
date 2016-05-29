package com.interview.intterviewbit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagLevelTraversal
{
	private static int left_to_right = 1;
	private static int right_to_left = 2;
	
	public List<Integer> traverse(TreeNode node){
		List<Integer> list = new ArrayList<Integer>();
		traverse(Arrays.asList(node), list, right_to_left);
		
		return list;
	}
	
	private void traverse(List<TreeNode> nodes, List<Integer> list, int mode){
		if(nodes.isEmpty()){
			return;
		}
		
		List<TreeNode> childNodes = new ArrayList<TreeNode>();
		
		if(mode == left_to_right){
			for(int i=nodes.size() - 1; i>=0; i--){
				TreeNode n = nodes.get(i);
				list.add(n.val);
				
				if(n.left != null){
					childNodes.add(n.left);
				}
				if(n.right != null){
					childNodes.add(n.right);
				}
			}
			
			mode = right_to_left;
		}
		else{
			for(int i=nodes.size() - 1; i>=0; i--){
				TreeNode n = nodes.get(i);
				list.add(n.val);
				
				if(n.right != null){
					childNodes.add(n.right);
				}

				if(n.left != null){
					childNodes.add(n.left);
				}
			}
			
			mode = left_to_right;
		}
		
		traverse(childNodes, list, mode);
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
