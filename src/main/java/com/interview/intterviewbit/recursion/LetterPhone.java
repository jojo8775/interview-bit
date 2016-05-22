package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterPhone
{
	private List<String> findCombination(List<String> strList){
		List<String> result = new ArrayList<String>();
		findCombnation(strList, 0, new char[strList.size()], result);
		
		return result;
	}
	
	private void findCombnation(List<String> strList, int strListCount, char[] chArr, List<String> result){
		if(strList.size() == strListCount){
			result.add(String.valueOf(chArr));
			return ;
		}
		
		for(int i = 0; i<strList.get(strListCount).length(); i++){
			chArr[strListCount] = strList.get(strListCount).charAt(i);
			findCombnation(strList, strListCount + 1, chArr, result);
		}
	}
	
	public static void main(String[] args){
		List<String> r = new LetterPhone().findCombination(Arrays.asList("1", "def"));
		
		for(String s : r){
			System.out.println(s);
		}
	}
}
