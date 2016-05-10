package com.interview.intterviewbit.random;

import java.util.ArrayList;
import java.util.List;

public class IntegerPalindrom
{
	public boolean isPalindrom(int n){
		
		List<Integer> list = new ArrayList<Integer>();
		
		int temp = n;
		while(temp > 0){
			list.add(temp%10);
			temp /=10;
		}
		
		int reverse = 0;
		for(int i=list.size() - 1, j=0; j<list.size(); j++, i--){
			reverse += Math.pow(10, i)*list.get(j);
		}
		
		return n == reverse;
	}
	
	public static void main(String[] args){
		System.out.println(new IntegerPalindrom().isPalindrom(010));;
	}
}
