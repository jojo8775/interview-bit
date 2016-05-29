package com.interview.intterviewbit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringConcatination
{
	public List<Integer> sol(String S, List<String> strList)
	{
		int totalLength = strList.get(0).length() * strList.size();
		int wordLength = strList.get(0).length();

		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		//index all the words 
		for(String str : strList){
			if(wordMap.containsKey(str)){
				wordMap.put(str, wordMap.get(str) + 1);
			}
			else{
				wordMap.put(str, 1);
			}
		}
		
		//checking each substring
		Map<String, Integer> tempMap = new HashMap<String, Integer>(wordMap);
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<S.length() - totalLength + 1; i=i+1){
			String str = S.substring(i, i+wordLength);
			if(tempMap.containsKey(str)){
				if(check(S.substring(i), tempMap, wordLength, totalLength)){
					result.add(i);
				}
			}
			
			tempMap = new HashMap<String, Integer>(wordMap);
		}
		
		return result;
	}
	
	private boolean check(String S, Map<String, Integer>map, int wordLength, int totalLength){
		for(int i=0; i<totalLength; i=i+wordLength){
			String str = S.substring(i, i + wordLength); 
			if(map.containsKey(str)){
				if(map.get(str) < 1){
					return false;
				}
				
				map.put(str, map.get(str)- 1);
			}
			else{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		List<Integer> result = new SubStringConcatination().sol("barfoothefoobarman", Arrays.asList("bar", "foo"));
		
		for(int i : result){
			System.out.print(i + ", ");
		}
	}
}
