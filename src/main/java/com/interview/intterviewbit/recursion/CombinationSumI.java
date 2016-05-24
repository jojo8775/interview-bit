package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumI
{
	public List<List<Integer>> find(List<Integer> nums, int t){
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		Collections.sort(nums);
		find(new ArrayList<Integer>(), 0, nums, r, t); 
		
		return r;
	}
	
	private void find(List<Integer> sofar, int start, List<Integer> rem, List<List<Integer>> r, int t){
		if(t==0){
			r.add(new ArrayList<Integer>(sofar));
			return;
		}
		
		for(int i=start; i<rem.size(); i++){
			if(i>start && rem.get(i) == rem.get(i-1)){
				continue;
			}
			
			if(t-rem.get(i) < 0){
				break;
			}
			
			sofar.add(rem.get(i));
			find(sofar, i, rem, r, t - rem.get(i));
			sofar.remove(sofar.size() - 1);
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> r = new CombinationSumI().find(Arrays.asList(2,2,3,6,7), 7);
		
		System.out.println(r.size());
	}
}
