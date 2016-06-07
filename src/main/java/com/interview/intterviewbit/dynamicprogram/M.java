package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M
{
	public List<Integer> findIndex(List<Integer> nums){
		int sum = 0;
		for(int i: nums){
			sum+=i;
		}
		
		List<Integer> result = new ArrayList<Integer>();
		find(result, nums, new ArrayList<Integer>(), sum/2, 0);
		
		return result;
	}

	private boolean find(List<Integer> result, List<Integer> nums, List<Integer> temp, int sum, int start)
	{
		if(start >= nums.size()){
			if(sum != 0){
				return false;
			}
		}
		
		if(sum == 0){
			result.addAll(temp);
			return true;
		}
		
		for(int i=start; i<nums.size(); i++){
			int t = sum - nums.get(i);
			
			if(t < 0){
				return false;
			}
			temp.add(nums.get(i));
			if(find(result, nums, temp, t, i+1)){
				return true;
			}
			temp.remove(temp.size()-1);
		}
		
		return false;
	}
	
	public static void main(String[] args){
		List<Integer> result = new M().findIndex(Arrays.asList(1,2,3,4));
		System.out.println(result.size());
	}
}
