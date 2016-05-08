package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class PowerOfInteger
{
	public boolean isPower(int a){
		if(a == 1){
			return true;
		}
		if(a <= 3){
			return false;
		}
		
		List<Integer> ff = findFactors(a);
		
		for(Integer f : ff){
			if(isMultiple(f, a)){
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isMultiple(int n1, int n2){
		while(n2%n1==0 && n2 > 1){
			n2 /= n1;
		}
		
		return n2==1;
	}
	
	private List<Integer> findFactors(int a){
		List<Integer> ff = new ArrayList<Integer>();
		
		for(int i=2;i<=a/2;i++){
			if(a%i==0){
				ff.add(i);
			}
		}
		
		return ff;
	}
}
