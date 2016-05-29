package com.interview.intterviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedList
{
	public List<Integer> merge(List<List<Integer>> lists){
		List<Integer> result = new ArrayList<Integer>();
		int length = lists.size()*lists.get(0).size(), k = lists.size();
		List<HeapNode> nodes = new ArrayList<HeapNode>();
		
		//putting all the first elements
		for(int i=0; i<k; i++){
			HeapNode node = new HeapNode(lists.get(i).get(0));
			node.arrIndex = i;
			node.nextIndex = 1;
			
			nodes.add(node);
			heapify(nodes, 0);
		}
		
		for(int i=0; i<length; i++){
			HeapNode min = nodes.get(0);
			result.add(min.val);
			
			HeapNode replacedNode = null;
			
			if(min.nextIndex < lists.get(0).size()){
				replacedNode = new HeapNode(lists.get(min.arrIndex).get(min.nextIndex));
				replacedNode.arrIndex = min.arrIndex;
				replacedNode.nextIndex = min.nextIndex + 1;
			}
			else{
				replacedNode = new HeapNode(Integer.MAX_VALUE);
			}
			
			nodes.set(0, replacedNode);
			heapify(nodes, 0);
		}
		
		return result;
	}
	
	private void heapify(List<HeapNode> nodes, int index){
		int twoX = index*2 + 1;
		int twoXPlus1 = index*2 + 2;
		
		int minIndex = index;
		if(twoX < nodes.size() && nodes.get(twoX).val < nodes.get(index).val){
//			swap(nodes, twoX, index);
			minIndex  = twoX;
		}
		
		if(twoXPlus1 < nodes.size() && nodes.get(twoXPlus1).val < nodes.get(minIndex).val){
//			swap(nodes, twoXPlus1, minIndex);
			minIndex  = twoXPlus1;
		}
		
		if(minIndex != index){
			swap(nodes, minIndex, index);
			heapify(nodes, minIndex);
		}
	}
	
	private void swap(List<HeapNode> nodes, int index1, int index2){
		HeapNode temp = nodes.get(index1);
		nodes.set(index1, nodes.get(index2));
		nodes.set(index2, temp);
	}
	
	private static class HeapNode{
		int val;
		int arrIndex;
		int nextIndex;
		
		public HeapNode(int val){
			this.val = val;
		}

		@Override
		public String toString()
		{
			return "HeapNode [val=" + val + ", arrIndex=" + arrIndex + ", nextIndex=" + nextIndex + "]";
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		ll.add(Arrays.asList(1,3,5,7));
		ll.add(Arrays.asList(2,4,6,8));
		ll.add(Arrays.asList(0,9,10,11));
		
		List<Integer> result = new MergeKSortedList().merge(ll);
		
		for(int i : result){
			System.out.print(i + ", ");
		}
	}
}
