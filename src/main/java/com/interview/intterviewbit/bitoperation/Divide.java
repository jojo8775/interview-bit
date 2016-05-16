package com.interview.intterviewbit.bitoperation;

public class Divide
{
	public int div(int divident, int divisor){
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		
		long a = Math.abs(divident), b = Math.abs(divisor), result = 0;
		
		while(a>=b){
			int ls = 0;
			while(a >= (b<<ls)){
				ls++;
			}
			
			ls --;
			
			result = result + (1<<ls);
			a = a - (b << ls);
		}
		
		if((divident > 0 && divisor > 0) || (divident < 0 && divisor < 0)){
			return (int) result;
		}
		
		return (int) (0 - result);
	}
	
	public static void main(String[] args){
		int r = new Divide().div(Integer.MIN_VALUE, -7906947);
		System.out.println(r);
	}
}
