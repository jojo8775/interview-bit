package com.interview.intterviewbit.string;

public class MultiplyNum
{
	public String multiply(String a, String b) {
	    String ra = new StringBuilder(a).reverse().toString();
	    String rb = new StringBuilder(b).reverse().toString();
	    
	    int[] arr = new int[a.length() + b.length()];
	    
	    for(int i = 0; i<ra.length(); i++){
	        for(int j=0; j<rb.length(); j++){
	            arr[i+j] += (ra.charAt(i) - '0') * (rb.charAt(j) - '0');
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    int carry = 0;
	    for(int i=0; i<arr.length; i++){
	        int num = arr[i] + carry;
	        if(num < 10){
	            sb.insert(0,num);
	            carry = 0;
	        }
	        else{
	            sb.insert(0,num%10);
	            carry = num/10;
	        }
	    }
	    
	    while(sb.charAt(0) == '0' && sb.length() > 1){
	        sb.deleteCharAt(0);
	    }
	    
	    return sb.toString();
	}
}
