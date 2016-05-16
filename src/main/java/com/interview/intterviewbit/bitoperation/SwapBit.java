package com.interview.intterviewbit.bitoperation;

public class SwapBit
{
	private long swapBit(long num, int i, int j){
		long a = (num >> i) & 1;
		long b = (num >> j) & 1;
		
		if((a ^ b) != 0){
			num = num ^ (1<<i | 1<<j);
		}
		
		return num;
	}
	
	public static void main(String[] args){
		long num = new SwapBit().swapBit(3, 5, 0);
		
		System.out.println(num);
	}
}
