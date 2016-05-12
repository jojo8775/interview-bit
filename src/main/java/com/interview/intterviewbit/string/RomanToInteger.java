package com.interview.intterviewbit.string;

public class RomanToInteger
{
	public int convertToInteger(String s)
	{
		int i=s.length() - 1, result = 0, cur = 0, prev = 0;
		while(i>=0){
			cur = findNumber(s.charAt(i--)); 
			if(prev > cur){
				result -= cur;
			}
			else{
				result += cur;
			}
			prev = cur;
		}
		
		return result;
	}

	private int findNumber(char ch)
	{
		switch (ch)
		{
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;

		default:
			return 0;
		}
	}
}
