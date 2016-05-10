package com.interview.intterviewbit.math;

public class ExcelTitle
{
	public int getColumn(String s){
		int result = 0, n = s.length()-1, powIndex = 0;
		
		while(n>=0){
			result += Math.pow(26,powIndex ++)*(s.charAt(n--) - 'A' + 1);
		}
		
		return result;
	}
}
