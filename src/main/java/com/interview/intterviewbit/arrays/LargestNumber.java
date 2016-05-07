package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumber
{
	public String sol(List<Integer> a){
		List<Node> nodes = new ArrayList<Node>();
		for(int i:a){
			nodes.add(new Node(i));
		}
		
		Collections.sort(nodes);
		
		StringBuilder s = new StringBuilder();
		for(Node n : nodes){
			s.append(n.num);
		}
		
		return s.toString();
	}
	
	private static class Node implements Comparable<Node>{
		private int num;
		public Node(int num){
			this.num = num;
		}
		
		public int compareTo(Node o)
		{
			int n1 = Integer.valueOf(String.valueOf(o.num) + String.valueOf(num));
			int n2 = Integer.valueOf(String.valueOf(num) + String.valueOf(o.num));
			if(n2 > n1){
				return -1;
			}
			else if(n2 < n1){
				return 1;
			}
			
			return 0;
		}
	}
	
	public static void main(String[] args){
		new LargestNumber().sol(Arrays.asList(9,98));
	}
}
