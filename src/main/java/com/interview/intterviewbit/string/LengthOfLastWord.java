package com.interview.intterviewbit.string;

public class LengthOfLastWord
{
	public int lastWordLength(String a){
	    int length = 0;
	    
	    for(int i=a.length()-1; i>=0; i--){
	        if(a.charAt(i) != ' '){
	            while(i>=0 && a.charAt(i) != ' '){
	                length++;
	                i--;
	            }
	            
	            break;
	        }
	    }
	    
	    return length;
	}
}
