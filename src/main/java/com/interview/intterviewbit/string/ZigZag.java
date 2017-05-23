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
	
	public String findZigZag(String str, int rows){
	    if(rows == 1){
	        return str;
	    }

	    StringBuilder[] sbArr = new StringBuilder[rows];
	    for(int i=0; i<sbArr.length; i++){
	        sbArr[i] = new StringBuilder();
	    }
	    
	    int count = 0, offset = 1;
	    for(int i=0; i<str.length(); i++){
	        sbArr[count].append(str.charAt(i));
	        count += offset;
	        if(count < 0){
	            count+=2;
	            offset *= -1;
	        }
	        else if(count == rows){
	            count -= 2;
	            offset *= -1;
	        }
	    }
	    
	    StringBuilder result = new StringBuilder();
	    for(StringBuilder sb : sbArr){
	        result.append(sb.toString());
	    }
	    
	    return result.toString();
	}
	
	public static void main(String[] args){
		System.out.println(new ZigZag().zigzag("abcdefghij", 4));
		System.out.println(new ZigZag().findZigZag("abcdefghij", 4));
	}
}
