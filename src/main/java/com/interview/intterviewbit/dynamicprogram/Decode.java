package com.interview.intterviewbit.dynamicprogram;

public class Decode
{
	public int numDecodings(String a) {
	    int[] arr = new int[a.length() + 1];
	    arr[0] = 1;
	    if(a.charAt(0) == '0'){
	        arr[1] = 0;
	    }
	    else{
	        arr[1] = 1;
	    }
	    
	    for(int i=2; i<=a.length(); i++){
	        if(isValid(a.substring(i-1, i))){
	            arr[i] = arr[i-1];
	        }
	        
	        if(isValid(a.substring(i-2, i))){
	            arr[i] += arr[i-2];
	        }
	        
	        if(arr[i] == 0){
	        	return 0;
	        }
	    }
	    
	    return arr[a.length()];
	}
	
	private boolean isValid(String s){
	    if(s.charAt(0) == '0'){
	        return false;
	    }
	    
	    int i = Integer.valueOf(s);
	    
	    return i>=1 && i<=26;
	}
	
	public static void main(String[] args){
//		int i = new Decode().numDecodings("32925665678138257423442343752148360796465852883409126159293254159974370974059818198867156827877059067081419274873853679038");
		int i = new Decode().numDecodings("743709");
		System.out.println(i);
	}
}
