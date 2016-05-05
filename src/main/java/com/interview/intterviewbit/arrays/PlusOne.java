package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne
{
	public List<Integer> plusOne(List<Integer> a) {
	    if(a==null || a.size()==0){
	        return null;
	    }
	    
	    int carry=1, lastNonZeroIndex = 0;
	    
	    
	    for(int i=a.size() - 1; i>=0; i--){
	        if(carry == 0){
	            break;
	        }
	        int temp = a.get(i) + carry;
	        if(temp > 9){
	            carry = temp - 9;
	            a.set(i,0);
	        }
	        else{
	            a.set(i,temp);
	            carry = 0;
	        }
	    }
	    
	    if(carry==0){
	        while(lastNonZeroIndex < a.size()){
	        if(a.get(lastNonZeroIndex) > 0){
	            break;
	        }
	        lastNonZeroIndex ++;
    	    }
    	    
    	    if(lastNonZeroIndex > 0){
    	    	List<Integer> result = new ArrayList<Integer>();
    	        for(int i=lastNonZeroIndex; i<a.size(); i++){
    	            result.add(a.get(i));
    	        }
    	        
    	        return result;
    	    }
    	    else{
    	        return a;  
    	    } 
	    }
	    else {
	        List<Integer> result = new ArrayList<Integer>(a.size() + 1);
	        result.add(carry);
	        result.addAll(a);
	        
	        return result;
	    }
	}
	
	public static void main(String[] args){
		List<Integer> a = Arrays.asList(9,9,9);
		
		for(int i : new PlusOne().plusOne(a)){
			System.out.print(i + ", ");
		}
	}
}
