package com.interview.intterviewbit.topointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersection
{
	public List<Integer> find(List<Integer> l1, List<Integer> l2)
	{
		List<Integer> sl = l1;
		if(l1.size() > l2.size()){
			sl = l2;
			l2 = l1;
		}
		
		int i=0,j=0,m=sl.size(),n=l2.size();
		List<Integer> result = new ArrayList<Integer>();
		while(i<m){
			if(j>=n){
				break;
			}
			int element1=sl.get(i);
			while(j<n){
				if(l2.get(j).equals(element1)){
					result.add(element1);
					j++;
					break;
				}
				if(l2.get(j) > element1){
					break;
				}
				j++;
			}
			i++;
		}
		
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> r = new FindIntersection().find(Arrays.asList(1,2,3,3,4,5,6), Arrays.asList(3,3,5));
		
		for(int i : r){
			System.out.print(i + ", ");
		}
		
		System.out.println();
	}
}
