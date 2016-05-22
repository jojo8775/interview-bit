package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartision
{
	public List<String> partision(String s){
		List<String> result = new ArrayList<String>();
		
		for(int i=0; i<s.length(); i++){
			for(int j=i+1, k=0; j<= s.length(); j++, k++){
				String str = s.substring(k,j);
				if(isPalindrom(str)){
					result.add(str);
				}
			}
		}
		
		return result;
	}
	
	private boolean isPalindrom(String str){
		int b = 0, e = str.length() - 1;
		while(b < e){
			if(str.charAt(b++) != str.charAt(e--)){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		List<String> r = new PalindromPartision().partision("aab");
		
		for(String s : r){
			System.out.println(s);
		}
	}
}
