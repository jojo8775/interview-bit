package com.interview.intterviewbit.math;


/**
 *purpose of this problem is if arr[i] = j then make arr[j] = i; 
 *
 *This is done using a mathametical trick. So A = B + C * n if(B,C < N) then B = A%N and C=A/N 
 */
public class RearrangeArray
{
	public void rearrange(int[] arr){
		int n = arr.length;
		for(int i=0; i<n; i++){
			arr[i] += (arr[arr[i]]%n)*n;
		}
		
		for(int i=0; i<n; i++){
			arr[i] /= n;
		}
	}
}
