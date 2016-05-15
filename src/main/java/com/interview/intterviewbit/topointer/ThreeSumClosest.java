package com.interview.intterviewbit.topointer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ThreeSumClosest
{
	public int sum(List<Integer> list, int target){
		int result = 0, sum = 0, diff = Integer.MAX_VALUE;
		Collections.sort(list);
		
		for(int i = 0; i<list.size(); i++){
			int j = i+1, k=list.size()-1;
			while(j<k){
				sum = list.get(i) + list.get(k) + list.get(j);
				
				if(sum == target){
					return sum;
				}
				
				int offset = Math.abs(sum - target);
				
				System.out.println(offset);
				if(diff > offset){
					diff = offset;
					result = sum;
				}
				
				if(sum > target){
					k--;
				}
				else{
					j++;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> ll = Arrays.asList( 5, -2, -1, -10, 10);
		int r = new ThreeSumClosest().sum(ll, 5);
		System.out.println(r);
	}
}
