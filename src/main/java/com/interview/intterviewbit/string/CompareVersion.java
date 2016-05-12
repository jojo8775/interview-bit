package com.interview.intterviewbit.string;

import java.math.BigInteger;
import java.util.Formatter.BigDecimalLayoutForm;
import java.util.regex.Pattern;

//TODO: this is an incomplete solution

public class CompareVersion
{
	public int compareVersion(String a, String b) {
	    String[] arr1 = a.split("[.]");
	    String[] arr2 = b.split("[.]");
	    
	    int m=arr1.length - 1, n=arr2.length-1;
	    while(m>=0){
	    	BigInteger num = new BigInteger(arr1[m]);
	    	if(num.compareTo(BigInteger.ZERO) != 0){
	    		break;
	    	}
	    	m--;
	    }
	    
	    while(n>=0){
	    	BigInteger num = new BigInteger(arr2[n]);
	    	if(num.compareTo(BigInteger.ZERO) != 0){
	    		break;
	    	}
	    	n--;
	    }
	    
	    int i=0,j=0;
	    while(i<=m && j<=n){
	    	BigInteger n1 = new BigInteger(arr1[i++]);
	    	BigInteger n2 = new BigInteger(arr2[j++]);
	    	
	    	int r = n1.compareTo(n2);
	    	if(r<0){
	    		return -1;
	    	}
	    	else if(r>0){
	    		return 1;
	    	}
	    }
	    
	    if(i>m && j>n){
	    	return 0;
	    }
	    else if(i>m){
	    	return -1;
	    }
	    else{
	    	return 1;
	    }
	}
	
	public static void main(String[] args){
		System.out.println(new CompareVersion().compareVersion("444444444444444444444444", "444444444444444444444444"));
		System.out.println(new CompareVersion().compareVersion("1.0.0", "1"));
		System.out.println(new CompareVersion().compareVersion("1.13.8", "1.13"));
	}
}
