package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxConsecutiveGap
{
	public int maximumGap(final List<Integer> a) {
	    if(a.size() < 2){
	        return 0;
	    }
	    
	    List<Integer> ll = new ArrayList<Integer>(a);
	    Collections.sort(ll);
	    int maxDiff = Integer.MIN_VALUE;
	    for(int i=1; i<a.size(); i++){
	        maxDiff = Math.max(maxDiff, ll.get(i) - ll.get(i-1));
	    }
	    
	    return maxDiff;
	}
	
	public static void main(String[] args){
		new MaxConsecutiveGap().maximumGap(Arrays.asList(1,10,5));
	}
}
