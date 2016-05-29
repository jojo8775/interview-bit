package com.interview.intterviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeKListII
{
	public ListNode merge(List<ListNode> a){
		
		LinkedList<HeapNode> heapNodes = new LinkedList<HeapNode>();
		//putting the first node
		for(int i=0; i<a.size(); i++){
			ListNode node = a.get(i);
			
			if(node == null){
				continue;
			}
			
			heapNodes.addFirst(new HeapNode(node));
			heapify(heapNodes, 0);
		}
		
		ListNode head = new ListNode(0), current = head;
		
		while(true){
			HeapNode minNode = heapNodes.get(0);
			if(minNode.dummy){
				break;
			}
			
			current.next = minNode.node;
			current = current.next;
			
			HeapNode replacementNode = null;
			
			if(minNode.node.next != null){
				replacementNode = new HeapNode(minNode.node.next);
			}
			else{
				replacementNode = new HeapNode(new ListNode(Integer.MAX_VALUE));
				replacementNode.dummy = true;
			}
			
			heapNodes.set(0, replacementNode);
			heapify(heapNodes, 0);
		}
		
		return head.next;
	}
	
	private void heapify(LinkedList<HeapNode> nodes, int index){
		int twoX = index*2 + 1, twoXplusOne = index*2 + 2, minIndex = index;
		
		if(twoX < nodes.size() && nodes.get(twoX).node.val <= nodes.get(index).node.val){
			minIndex = twoX;
		}
		
		if(twoXplusOne < nodes.size() && nodes.get(twoXplusOne).node.val <= nodes.get(minIndex).node.val){
			minIndex = twoXplusOne;
		}
		
		if(minIndex != index){
			swap(nodes, minIndex, index);
			heapify(nodes, minIndex);
		}
	}
	
	private void swap(List<HeapNode> nodes, int idx1, int idx2){
		HeapNode temp = nodes.get(idx1);
		nodes.set(idx1, nodes.get(idx2));
		nodes.set(idx2, temp);
	}
	
	private static class HeapNode{
		ListNode node;
		boolean dummy;
		
		public HeapNode(ListNode node){
			this.node = node;
		}
	}
	
	private static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
//		List<ListNode> a = Arrays.asList(createNode(1,3,5,7), createNode(2,4,6,8), createNode(0,9,10,11));
		
		List<ListNode> a = Arrays.asList(createNode(8, 20, 38, 44, 55, 65, 66, 79, 87),
				createNode(68, 72),
				createNode(5, 55, 61, 73, 89),
				createNode(30, 73),
				createNode(28, 73, 84, 96),
				createNode(54, 82, 83),
				createNode(15, 33, 38, 94, 100),
				createNode(4),
				createNode(22, 32, 42, 64, 86),
				createNode(11, 78));
		
		ListNode r = new MergeKListII().merge(a);
		
		while(r != null){
			System.out.print(r.val + ", ");
			r = r.next;
		}
	}
	
	private static ListNode createNode(int ... args){
		ListNode head = new ListNode(0), currentNode = head;
		
		for(int i : args){
			currentNode.next = new ListNode(i);
			currentNode = currentNode.next;
		}
		
		return head.next;
	}
}
