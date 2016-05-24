package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII
{
	public List<List<Integer>> findSet(List<Integer> nums, int t){
		Collections.sort(nums);
		
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		findSet(new ArrayList<Integer>(), 0, nums, t, r);
		return r;
	}
	
	private void findSet(List<Integer> sofar, int start, List<Integer> remaining, int t, List<List<Integer>> r){
		if(t==0){
			r.add(new ArrayList<Integer>(sofar));
			return;
		}
		
		for(int i=start; i<remaining.size(); i++){
			if(i>start && remaining.get(i) == remaining.get(i-1)){
				continue;
			}
			
			if(t - remaining.get(i) >= 0){
				sofar.add(remaining.get(i));
				findSet(sofar, i + 1,remaining, t - remaining.get(i), r);
				sofar.remove(sofar.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> r = new CombinationSumII().findSet(Arrays.asList(10,1, 1,2,7,6,1,5), 8);
		
		for(List<Integer> ll : r){
			for(int i : ll){
				System.out.print(i + ", ");
			}
			
			System.out.println();
		}
	}
}
