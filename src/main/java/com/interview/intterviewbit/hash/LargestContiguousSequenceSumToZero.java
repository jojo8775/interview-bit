package com.interview.intterviewbit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestContiguousSequenceSumToZero
{
	public List<Integer> find(List<Integer> nums)
	{
		if(nums.size() == 0){
			return new ArrayList<Integer>();
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int sum=nums.get(0), b=Integer.MAX_VALUE, e=-1;
		
		if(sum == 0){
			b=0;
			e=0;
		}
		
		map.put(sum, 0);
		
		for(int i=1; i<nums.size(); i++){
			sum+=nums.get(i);
			
			if(sum == 0){
				b = 0;
				e = i;
			}
			else if(map.containsKey(sum)){
				if(b == Integer.MAX_VALUE){
					b = map.get(sum) + 1;
					e = i;
				}
				else if ((e-b) < (i - (map.get(sum) + 1))){
					b = map.get(sum) + 1;
					e = i;
				}
			}
			else{
				map.put(sum, i);
			}
		}

		if(b == Integer.MAX_VALUE){
			return new ArrayList<Integer>();
		}
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=b; i<=e; i++){
			result.add(nums.get(i));
		}
		
		return result;
	}

	public static void main(String[] args)
	{
		List<Integer> r = new LargestContiguousSequenceSumToZero().find(Arrays.asList(1, 2, -2, 4, -4));
//		List<Integer> r = new LargestContiguousSequenceSumToZero().find(Arrays.asList(1,2,-3,3));
		for(int i: r){
			System.out.print(i + ", ");
		}
	}
}
