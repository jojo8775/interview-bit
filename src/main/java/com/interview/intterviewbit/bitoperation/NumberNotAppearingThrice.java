package com.interview.intterviewbit.bitoperation;

import java.util.Arrays;
import java.util.List;

public class NumberNotAppearingThrice
{
	public int singleNumber(final List<Integer> a) {
	    long result = 0;
	    
	    for(int i=0; i<32; i++){
	        int ones = 0;
	        for(int j=0; j<a.size(); j++){
	            if((a.get(j) & 1<<i) > 0){
	                ones++;
	            }
	        }
	        
	        if(ones%3 == 0){
	            result = result | 0<<i;
	        }
	        else{
	            result = result | 1<<i;
	        }
	    }
	    
	    return (int) result;
	}
	
	public static void main(String[] args){
		List<Integer> ll = Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1);
		int r = new NumberNotAppearingThrice().singleNumber(ll);
		System.out.println(r);
	}
}
