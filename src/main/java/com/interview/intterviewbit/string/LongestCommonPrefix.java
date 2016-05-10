package com.interview.intterviewbit.string;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix
{
	public String longestCommonPrefix(List<String> a) {
	    StringBuilder sb = new StringBuilder();
        boolean reachedEnd = false;
        int count = 0;
        while(!reachedEnd){
            char ch = ' ';
            if(count < a.get(0).length()){
                ch = a.get(0).charAt(count);
            }
            else{
                reachedEnd = true;
                continue;
            }
            
            for(int i=1; i<a.size(); i++){
                String s = a.get(i);
                if(count == s.length() || s.charAt(count) != ch){
                    reachedEnd = true;
                    break;
                }
            }
            
            if(!reachedEnd){
                sb.append(ch);
            }
            count++;
        }
        
        return sb.toString();
	}
	
	public static void main(String[] args){
		List<String> l = Arrays.asList("abcdefgh", "aefghijk", "abcefgh");
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(l));
	}
}
