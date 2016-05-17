package com.interview.intterviewbit.topointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortColor
{
	public void sortColors(List<Integer> a) {
	    int[] arr = new int[3];
	    
	    for(int i=0; i<a.size(); i++){
            arr[a.get(i)]++;	        
	    }
	    
	    int idx = 0;  
	    for(int i=0; i<arr.length; i++){
	        for(int j=0; j<arr[i]; j++){
	            a.set(idx++, i);
	        }
	    }
	}
	
	public static void main(String[] args){
		new SortColor().sortColors(new ArrayList<Integer>(Arrays.asList(0)));
	}
}
