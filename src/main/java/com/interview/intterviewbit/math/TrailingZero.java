package com.interview.intterviewbit.math;

public class TrailingZero
{
	public int findZero(int a){
		int zeros = 0;
		
		for(int i=5; a/i>=1; i = i*5){
			zeros += a/i;
		}
		
		return zeros;
	}
	
	public static void main(String[] args){
		int r = new TrailingZero().findZero(9247);
		
		System.out.println(r);
	}
}
