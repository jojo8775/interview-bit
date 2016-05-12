package com.interview.intterviewbit.string;

public class AddBinaryString
{
	public String addNumbers(String a, String b) {
	    int i=a.length() - 1, j = b.length() - 1;
	    char carry = '0', result = '0';
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(true){
	        result = carry;
	        carry = '0';
	        
	        if(i>=0){
    	        char ch1 = a.charAt(i);
    	        
    	        if(result == '1'){
    	            if(ch1 == '1'){
    	                result = '0';
    	                carry = '1';
    	            }
    	        }
    	        else{
    	            result = ch1;
    	        }
    	        
	            i--;
	        }
	        
	        if(j>=0){
	            char ch2 = b.charAt(j);
	            
	            if(result == '1'){
	                if(ch2 == '1'){
	                    carry = '1';
	                    result = '0';
	                }
	            }
	            else{
	                result = ch2;
	            }
	            
	            j--;
	        }
	        
	        sb.append(result);
	        
	        if(i<0 && j<0 && carry == '0'){
	            break;
	        }
	    }
	    
	    return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		System.out.println(new AddBinaryString().addNumbers("111", "11"));
	}
}
