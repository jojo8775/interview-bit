package com.interview.intterviewbit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateBalancedBST
{
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    TreeNode node = populate(0, a.size() - 1, a);
	    return node;
	}
	
	private TreeNode populate(int beg, int end, List<Integer> a){
	    if(beg <= end){
	        int mid = (end + beg) >> 1;
	        TreeNode node = new TreeNode(a.get(mid));
	        node.left = populate(beg, mid - 1, a);
	        node.right = populate(mid + 1, end, a);
	        
	        return node;
	    }
	    
        return null;
	}
	
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}

		@Override
		public String toString()
		{
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public static void main(String[] args){
		TreeNode node = new CreateBalancedBST().sortedArrayToBST(Arrays.asList(1,2,3,4,5,6,7,8,9));
	}
}
