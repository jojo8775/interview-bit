package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray
{
	public List<Integer> sol(List<Integer> a){
		int  currentStart=0, maxStart=0, currentEnd=0, maxEnd=0;
	    long currentMax = a.get(0), max = currentMax;
	    
	    for(int i=1; i<a.size(); i++){
	        if(a.get(i) >= 0){
	        	if(currentMax < 0){
	        		currentMax = a.get(i);
	        		currentStart = i;
	        	}
	        	else{
	        		currentMax += a.get(i);
	        	}
	            
                currentEnd = i;
	        }
	        else{
                currentMax = a.get(i);
	            currentStart = i;
	            currentEnd = i;
	        }
	        
	        if(currentMax > max){
	            max = currentMax;
	            maxStart = currentStart;
	            maxEnd = currentEnd;
	        }
	        else if(currentMax == max){
	            if((maxEnd - maxStart) < (currentEnd - currentStart)){
	                maxEnd = currentEnd;
	                maxStart = currentStart;
	            }
	        }
	    }
	    
	    if(max < 0){
	        return new ArrayList<Integer>();
	    }
	    
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    int count = maxStart;
	    while(count <= maxEnd){
	        result.add(a.get(count++));
	    }
	    
	    return result;
	}
	
	public static void main(String[] args){
//		new MaxNonNegativeSubArray().sol(Arrays.asList(-1,-1,-1, -1, -1));
		new MaxNonNegativeSubArray().sol(Arrays.asList(0,0,-1,0));
//		new MaxNonNegativeSubArray().sol(Arrays.asList(-846930886, -1714636915, 424238335, -1649760492));
	}
}
