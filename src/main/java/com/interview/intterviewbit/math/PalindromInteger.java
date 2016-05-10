package com.interview.intterviewbit.math;

public class PalindromInteger
{
	public boolean isPalindrom(int a){
		String s = String.valueOf(a);
		int beg = 0, end = s.length() - 1;
		while(beg < end){
			if(s.charAt(beg++) != s.charAt(end--)){
				return false;
			}
		}
		
		return true;
	}
}
