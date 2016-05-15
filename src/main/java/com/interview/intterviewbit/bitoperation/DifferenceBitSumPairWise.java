package com.interview.intterviewbit.bitoperation;

public class DifferenceBitSumPairWise
{
	public int diff(int[] arr){
		int result= 0;
		long temp = 1;
		int MOD = 1000000007;
		
		for(int i=0; i<32;i++){
			int count = 0;
			for(int j=0; j<arr.length; j++){
				long l = arr[j];
				if((l & (temp<<i)) > 1){
					count++;
				}
			}
			
			result += (count * (arr.length - count) * 2) % MOD;
			result %= MOD;
			
			System.out.println(result);
		}
		
		return result;
	}
	
	public static void main(String[] args){
		int[] arr = {81, 13, 2, 7, 96};
		int r = new DifferenceBitSumPairWise().diff(arr);
		System.out.println(r);
	}
}
