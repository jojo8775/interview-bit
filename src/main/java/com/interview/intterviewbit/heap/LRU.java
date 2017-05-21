package com.interview.intterviewbit.heap;

import java.util.HashMap;
import java.util.Map;

public class LRU
{
	private final int capacity;
	private Node head = null, end = null;
	private Map<Integer, Node> map = new HashMap<Integer, Node>();
	
	public LRU(int capacity){
		this.capacity = capacity;
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node node = map.get(key);
			remove(node);
			setHead(node);
			
			return node.val;
		}
		
		return -1;
	}
	
	public void set(int key, int val){
		if(map.containsKey(key)){
			Node old = map.get(key);
			old.val = val;
			remove(old);
			setHead(old);
		}
		else{
			if(map.size() == capacity){
				map.remove(end.key);
				remove(end);
			}
			
			Node n = new Node(val, key);
			setHead(n);
			map.put(key, n);
		}
	}
	
	public void remove(Node n){
		if(n.pre != null){
			n.pre.next = n.next;
		}
		else{
			head = n.next;
		}
		
		if(n.next != null){
			n.next.pre = n.pre;
		}
		else{
			end = n.pre;
		}
	}
	
	public void setHead(Node n){
		n.next = head;
		
		if(head != null){
			head.pre = n;
		}
		
		head = n;
		
		if(end == null){
			end = head;
		}
	}
	
	private static class Node{
		int val;
		int key;
		Node pre;
		Node next;
		
		public Node(int val, int key){
			this.val = val;
			this.key = key;
		}
	}
	
	public static void main(String[] args){
		LRU lru = new LRU(1);
		lru.set(2, 1);
		
		System.out.println(lru.get(2));
	}
}
