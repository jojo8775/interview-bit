package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII
{
	public List<String> getSentence(String s, Set<String> dic){
		int[] arr = new int[s.length()];
		
		int firstIdx = 0;
		
		List<String> result = new ArrayList<String>();
		
		while(firstIdx < s.length()){
			int prevIdx = 0, curIdx = firstIdx;
			for(int i = firstIdx; i<s.length(); i++){
				if(dic.contains(s.substring(curIdx, i+1))){
					arr[prevIdx] = i;
					prevIdx = curIdx;
				}
			}
			
			if(curIdx == firstIdx){
				break;
			}
			
			if(arr[prevIdx] == arr.length - 1){
				StringBuilder sb = new StringBuilder();
				sb.append(s.substring(0, arr[0] + 1));
				for(int j=arr[0] + 1; j<arr.length; j = arr[j] + 1){
					sb.append(" ").append(s.substring(j, arr[j] + 1));
				}
				
				result.add(sb.toString());
			}
			
			firstIdx = arr[0] + 1;
		}
		
		Collections.sort(result);
		return result;
	}
	
	public static void main(String[] args){
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dogs");
		
		List<String> result = new WordBreakII().getSentence("catsanddogs", set);
		System.out.println(result.size());
	}
}
