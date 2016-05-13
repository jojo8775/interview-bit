package com.interview.intterviewbit.string;

public class ZigZag
{
	public String zigzag(String a, int b){
		int start=0, end=a.length()-1, count=0;
	    
	    if(b == 1){
	        return a;
	    }
	    
	    StringBuilder[] sbArr = new StringBuilder[b];
	    for(int i=0; i<sbArr.length; i++){
	        sbArr[i] = new StringBuilder();
	    }
	    
	    while(true){
	        while(start<=end && count < b-1){
	            sbArr[count++].append(a.charAt(start++));
	        }
	        
	        while(start<=end && count > 0){
	            sbArr[count--].append(a.charAt(start++));
	        }
	        
	        if(start>end){
	            break;
	        }
	    }
	    
	    StringBuilder result = new StringBuilder();
	    for(StringBuilder sb : sbArr){
	        result.append(sb);
	    }
	    
	    return result.toString();
	}
	
	public static void main(String[] args){
		String r = new ZigZag().zigzag("abcdefghij", 4);
		System.out.println(r);
	}
}
