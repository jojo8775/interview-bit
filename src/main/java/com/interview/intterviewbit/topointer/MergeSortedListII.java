package com.interview.intterviewbit.topointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedListII
{
	public void merge(List<Integer> l1, List<Integer> l2){
		List<Integer> bl = l1, sl = l2;
		if(l1.size() < l2.size()){
			bl = l2;
			sl = l1;
		}
		
		int i=bl.size()-1;
		
		bl.addAll(sl);
		int j=bl.size()-1;
		while(i>=0 && j>i){
			int e1 = bl.get(i);
			int e2 = bl.get(j);
			
			if(e2 < e1){
				swap(bl,i,j);
				i--;
			}
			
			j--;
		}
		
		
		for(int a : bl){
			System.out.print(a + ", ");
		}
	}
	
	private void swap(List<Integer> ll, int i, int j){
		int t = ll.get(i);
		ll.set(i, ll.get(j));
		ll.set(j, t);
	}
	
	public static void main(String[] args){
		new MergeSortedListII().merge(new ArrayList<Integer>(Arrays.asList(3)), new ArrayList<Integer>(Arrays.asList(-4,-3)));
	}
}
