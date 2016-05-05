package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class MinimumOperationToGetMax
{
	private List<Integer> sol(String s)
	{
		int[] arr = new int[s.length()];
		boolean containsZero = false;
		for(int i=0; i<arr.length; i++){
			if(s.charAt(i) == '0'){
				arr[i] = 1;
				containsZero = true;
			}
			else{
				arr[i] = -1;
			}
		}
		
		int maxStart=0,maxEnd=0,currentStart=0, currentEnd=0, currentMax=arr[0], max = currentMax;
		
		for(int i=1; i<arr.length; i++){
			if(currentMax < 0){
				currentMax = arr[i];
				currentStart = i;
				currentEnd = i;
			}
			else{
				currentMax += arr[i];
				currentEnd = i;
			}
			
			if(currentMax > max){
				max = currentMax;
				maxStart = currentStart;
				maxEnd = currentEnd;
			}
		}
		
		if(!containsZero){
			return new ArrayList<Integer>();
		}
		
		List<Integer> result = new ArrayList<Integer>(2);
		result.add(maxStart+1);
		result.add(maxEnd+1);
		
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> ll = new MinimumOperationToGetMax().sol("1101010001");

		if(ll.isEmpty()){
			System.out.println("No operation required");
		}
		else{
			System.out.println(ll.get(0) + ", " + ll.get(1));
		}
	}
}
