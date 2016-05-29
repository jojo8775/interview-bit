package com.interview.intterviewbit.hash;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubString
{
	public int lengthOfLongestSubstring(String a) {
	    if(a.isEmpty()){
	        return 0;
	    }
	    
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    
	    int beg = 0, end = 0, length = 0;
	    
	    for(int i=0; i<a.length(); i++){
	        char ch = a.charAt(i);
	        if(map.containsKey(ch)){
	           length = Math.max(length, end - beg);
	           beg = Math.max(map.get(ch) + 1, beg);
	        }

	        end = i;
	        map.put(ch, i);
	    }
	    
	    return Math.max(length, end - beg) + 1;
	}
	
	public int length_anotherApproach(String a){
		int[] arr = new int[128];
		
		int beg = 0, end = 0, length = 0;
		
		for(int i=0; i<a.length(); i++){
			
			char ch = a.charAt(i);
			if(arr[ch] > 0){
				length = Math.max(length, end - beg);
				beg = Math.max(beg, arr[ch]);
			}
			arr[ch] = i+1;
			end = i;
		}
		
		return Math.max(length, end - beg + 1);
	}
}
