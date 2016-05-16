package com.interview.intterviewbit.bitoperation;

public class ReverseInteger
{
	public long reverse(long num){
		long result = num;
		for(int i=0; i<16; i++){
			result = swapBit(result, i, 32 - i - 1);
		}
		
		return result;
	}
	
	private long swapBit(long num, int i, int j){
		long a = (num >> i) & 1;
		long b = (num >> j) & 1;
		long c = 1;
		
		if((a ^ b) != 0){
			num = num  ^ (c << i | c << j);
		}
		
		return num;
	}
	
	public static void main(String[]  args){
		long num = new ReverseInteger().reverse(3);
		System.out.println(num);
	}
}
