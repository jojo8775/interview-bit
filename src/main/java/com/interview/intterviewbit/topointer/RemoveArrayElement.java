package com.interview.intterviewbit.topointer;

import java.util.ArrayList;

public class RemoveArrayElement
{
	public int removeElement(ArrayList<Integer> a, int b) {
	    int i=0,j=i,n=a.size();
	    
	    while(j<n){
	        if(!a.get(j).equals(b)){
	            a.set(i++,a.get(j));
	        }
	        j++;
	    }
        
        while((n-1) >= i){
            a.remove(--n);
        }	    
	    
	    return a.size();
	}
}
