package com.interview.intterviewbit.topointer;

import java.util.Arrays;
import java.util.List;

public class MaxContainerArea
{
	public int maxArea(List<Integer> a) {
	    int l=0,r=a.size()-1,n=a.size(),maxArea = 0, prevLeft = 0, prevRight = 0;
	    
	    while(r > l){
	        while(l < n && a.get(l) <= prevLeft){
	            l++;
	        }
	        
	        while(r > 0 && a.get(r) <= prevRight){
	            r--;
	        }
	        
            if(maxArea < (r - l) * Math.min(a.get(l), a.get(r))){
                maxArea = (r - l) * Math.min(a.get(l), a.get(r));
            }
            
            if(a.get(l) < a.get(r)){
            	prevLeft = a.get(l);
            }
            else{
            	prevRight = a.get(r);
            }
	    }
	    
	    return maxArea;
	}
	
	public static void main(String[] args){
		int r = new MaxContainerArea().maxArea(Arrays.asList(1,5,4,3));
		System.out.println(r);
	}
}
