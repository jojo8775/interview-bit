package com.interview.intterviewbit.string;

public class ReverseWord
{
	public String reverse(String s){
		String ss = s.trim();
		
		String[] sArr = ss.split(" +");
		StringBuilder result = new StringBuilder(sArr[sArr.length - 1]);
		
		for(int i=sArr.length - 2; i>= 0; i--){
			result.append(" ").append(sArr[i]);
		}
		
		return result.toString();
	}
	
	public static void main(String[] args){
		System.out.println(new ReverseWord().reverse("  this   is   a man    "));
	}
}
 	 	