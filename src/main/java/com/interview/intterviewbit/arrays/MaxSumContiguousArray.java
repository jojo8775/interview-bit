package com.interview.intterviewbit.arrays;

import java.util.List;

public class MaxSumContiguousArray
{
	//Implements kandans algorithm 
	public int findMax(List<Integer> A){
		int currentMax = A.get(0), max = currentMax;
		
		for(int i=1; i<A.size(); i++){
			if(currentMax < 0){
				currentMax = A.get(i);
			}
			else{
				currentMax += A.get(i);
			}
			
			max = Math.max(currentMax, max);
		}
		
		return max;
	}
}
