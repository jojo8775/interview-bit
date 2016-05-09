package com.interview.intterviewbit.math;

import java.util.HashMap;
import java.util.Map;

public class GCD
{
	public int gcd(int a, int b) {
		if(a==0){
			return b;
		}
		
		return gcd(b%a, a);
	}
	
	public static void main(String[] args){
		int r = new GCD().gcd(52, 704);
		System.out.println(r);
	}
}
