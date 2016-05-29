package com.interview.intterviewbit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram
{
	public List<List<Integer>> find(List<String> a){
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		
		for(int i=0; i<a.size(); i++){
			char[] cArr = a.get(i).toCharArray();
			Arrays.sort(cArr);
			
			if(!map.containsKey(String.valueOf(cArr))){
				map.put(String.valueOf(cArr), new ArrayList<Integer>());
			}
			
			List<Integer> ll = map.get(String.valueOf(cArr));
			ll.add(i);
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(String key : map.keySet()){
			result.add(map.get(key));
		}
		
		return result;
	}
	
	public static void main(String[] args){
		List<List<Integer>> r = new Anagram().find(Arrays.asList("cat", "dog", "god", "tca"));
		
		for(List<Integer> l : r){
			for(int i : l){
				System.out.print(i + ", ");
			}
			
			System.out.println();
		}
	}
}
