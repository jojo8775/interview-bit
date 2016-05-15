package com.interview.intterviewbit.binarysearch;

public class sqrt
{
	public int findSqrt(int num){
		long a = num, beg = 0, end = num/2 + 1;
		
		while(beg <= end){
			long mid = (beg+end)/2;
			if(mid*mid == a){
				return (int) mid; 
			}
			
			if(mid*mid < a){
				beg = mid + 1;
			}
			else{
				end = mid - 1;
			}
		}
		
		return (int) end;
	}
	
	public static void main(String[] args){
//		int r = new sqrt().findSqrt(Integer.MAX_VALUE);
		int r = new sqrt().findSqrt(1);
		System.out.println(r);
	}
}
