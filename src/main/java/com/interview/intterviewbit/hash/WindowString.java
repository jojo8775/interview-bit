package com.interview.intterviewbit.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WindowString
{
	public String find(String s1, String s2){
		if(s2.length() > s1.length()){
			return "";
		}
		
		Map<Character, Integer> toFind = new HashMap<Character,Integer>();
		Map<Character, Integer> found = new HashMap<Character,Integer>();
		for(int i=0; i<s2.length(); i++){
			char ch = s2.charAt(i);
			
			if(!toFind.containsKey(ch)){
				toFind.put(ch, 1);
				found.put(ch, 0);
			}
			else{
				int j = toFind.get(ch);
				toFind.put(ch, j+1);
			}
		}
		
		
		int beg=0, end=0,length=Integer.MAX_VALUE, tl = 0, fb=0, fe = 0, count = s2.length();
		
		for(int i=0; i<s1.length(); i++){
			char ch = s1.charAt(i);
			
			if(toFind.containsKey(ch)){
				if(found.get(ch) < toFind.get(ch)){
					count --;
				}
				
				int j=found.get(ch);
				found.put(ch, j+1);
				
				end = i;
				
				if(count < 1){
					while(beg<end){
						char begCh = s1.charAt(beg);
						if(!toFind.containsKey(begCh)){
							beg ++;
						}
						else if(toFind.get(begCh) < found.get(begCh)){
							found.put(begCh, found.get(begCh) - 1);
							beg ++;
						}
						else{
							break;
						}
					}
					
					tl = end-beg;
					if(tl < length){
						length = tl;
						fb = beg;
						fe = end;
					}
				}
			}
		}
		
		if(count > 0){
			return "";
		}
		
		while(end >= beg){
			char ch = s1.charAt(end);
			if(!found.containsKey(ch)){
				end --;
			}
			else if(found.get(ch) > toFind.get(ch)){
				found.put(ch, found.get(ch) - 1);
				end --;
			}
			else{
				break;
			}
		}
		
		tl = end-beg;
		if(tl < length){
			length = tl;
			fb = beg;
			fe = end;
		}
		
		return s1.substring(fb, fe + 1);
	}
	
	public static void main(String[] args){
//		String s = new WindowString().find("acbbaca", "abc");
		String s = new WindowString().find("ADOBECODEBANC", "ABC");
		System.out.println(s);
	}
}
