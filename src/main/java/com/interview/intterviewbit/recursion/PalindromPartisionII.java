package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartisionII
{
	private List<List<String>> partision(String s){
		List<List<String>> result = new ArrayList<List<String>>();
		partision(s, 0, new ArrayList<String>(), result);
		return result;
	}
	
	private void partision(String s, int start, List<String> p, List<List<String>> result){
		if(start == s.length()){
			List<String> rr = new ArrayList<>(p);
			result.add(rr);
			return;
		}
		
		for(int i=start + 1; i<=s.length(); i++){
			String ts = s.substring(start, i);
			if(isPalindrom(ts)){
				p.add(ts);
				partision(s, i, p, result);
				//need to remove the last element
				p.remove(p.size() - 1);
			}
		}
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
		List<List<String>> r = new PalindromPartisionII().partision("aab");
		
		for(List<String> ls : r){
			for(String s : ls){
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
}
