package com.interview.intterviewbit.binarysearch;

import java.util.List;

public class PowerFunction
{
	public long power(int a, int b, int d){
		if(b == 0){
			return 1;
		}
		
		long result = power(a, b/2, d);
		result %= d;
		a %= d;
		
		if(b%2==0){
			return result * result;
		}
		else{
			return a * result * result;
		}
	}
	
	public static void main(String[] args){
		System.out.println(new PowerFunction().power(71045970, 41535484, 64735492));
		
//		A : 71045970
//		B : 41535484
//		C : 64735492
	}
}
