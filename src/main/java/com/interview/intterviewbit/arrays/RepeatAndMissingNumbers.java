package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatAndMissingNumbers
{
	public ArrayList<Integer> sol(List<Integer> a){
		
		int numberAppearingTwice=0, numberMissing = 0;
		
		for(int i=0; i<a.size(); i++){
			int val = Math.abs(a.get(i));
			if(a.get(val-1)< 0){
				numberAppearingTwice = val;
			}
			else{
				int temp = a.get(val-1);
				a.set(val-1, -temp);
			}
		}
		
		for(int i=0; i<a.size(); i++){
			if(a.get(i) > 0){
				numberMissing = i+1;
				break;
			}
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>(2);
		result.add(numberAppearingTwice);
		result.add(numberMissing);
		
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> arr = Arrays.asList(3,2,4,1,3);
		new RepeatAndMissingNumbers().sol(arr);
	}
}
