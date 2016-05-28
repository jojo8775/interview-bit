package com.interview.intterviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistincNumbersInWindow
{
	public List<Integer> findNumbers(List<Integer> nums, int k){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int count = 0;
		for(int i=0; i<k; i++){
			int n = nums.get(i);
			if(!map.containsKey(n)){
				map.put(n, 1);
				count ++;
			}
			else{
				map.put(n, map.get(n) + 1);
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		result.add(count);
		
		int j = 0;
		for(int i=k; i<nums.size(); i++){
			int temp = map.get(nums.get(j));
			if(temp == 1){
				count --;
			}
			map.put(nums.get(j), temp - 1);
			
			if(map.containsKey(nums.get(i))){
				if(map.get(nums.get(i)) == 0){
					count ++;
				}
				
				map.put(nums.get(i), map.get(nums.get(i)) + 1);
			}
			else{
				map.put(nums.get(i), 1);
				count ++;
			}
			
			result.add(count);
			j++;
		}
		
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> r = new DistincNumbersInWindow().findNumbers(Arrays.asList(1,2,1,3,4,3), 3);
		
		for(int i : r){
			System.out.print(i + ", ");
		}
	}
}
