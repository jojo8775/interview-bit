package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray
{
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    Collections.sort(a);
	    
	    int index1=0, index2=0, mode=0;
        
	    while(index1 < a.size() - 1){
	        index2 = index1 + 1;
	        if(mode==0){
	            if(a.get(index1) < a.get(index2)){
	                swap(index1, index2, a);
	            }
	            mode = 1;
	        }
	        else if(mode == 1){
	            if(a.get(index1) > a.get(index2)){
	                swap(index1, index2, a);
	            }
	            
	            mode = 0;
	        }
	        
	        index1 += 1;
	    }

        return a;	    
	}
	
	private void swap(int index1, int index2, ArrayList<Integer> a){
        int temp = a.get(index1);
        a.set(index1, a.get(index2));
        a.set(index2, temp);
	}
}
