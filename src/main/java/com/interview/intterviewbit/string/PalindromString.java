package com.interview.intterviewbit.string;

public class PalindromString
{
	public int isPalindrome(String a) {
	    int ls= 'a', le='z', us='A', ue='Z', ns='0', ne='9';
	    
	    StringBuilder sb = new StringBuilder();
	    for(char ch : a.toCharArray()){
	        int i = ch;
	        if((i>=ls && i<=le) || (i>=us && i<=ue) || (i>=ns && i<=ne)){
	            sb.append(Character.toUpperCase(ch));
	        }
	    }
	    
	    String s1 = sb.toString();
	    String s2 = sb.reverse().toString();
	    
	    if(s1.equals(s2)){
	    	return 1;
	    }
	    
	    return 0;
	}
	
	public static void main(String[] args){
		System.out.println(new PalindromString().isPalindrome("A man, a plan, a canal: Panama"));
	}
}
