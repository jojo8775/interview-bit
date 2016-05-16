package com.interview.intterviewbit.binarysearch;

public class RotateArray
{
	public int[] rotate(int[] arr, int n){
		rotate(arr, 0, n);
		rotate(arr,n+1,arr.length - 1);
		rotate(arr, 0, arr.length - 1);
		
		return arr;
	}
	
	private int[] rotate(int[] arr, int beg, int end){
		while(beg<end){
			int temp = arr[beg];
			arr[beg] = arr[end];
			arr[end] = temp;
			beg++;
			end--;
		}
		
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		arr = new RotateArray().rotate(arr, 0);
		print(arr);
	}
	
	private static void print(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
}
