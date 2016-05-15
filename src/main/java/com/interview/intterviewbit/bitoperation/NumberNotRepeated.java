package com.interview.intterviewbit.bitoperation;

import java.util.List;

public class NumberNotRepeated
{
	public int findNumber(List<Integer> list){
		int temp = 0;
		
		for(int i : list){
			temp ^= i;
		}
		
		return temp;
	}
}
