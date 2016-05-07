package com.interview.intterviewbit.arrays;

public class PascalsTriangle
{
	public void sol(int k){
		int[] prevArr = new int[2];
		prevArr[0] = 1;
		prevArr[1] = 1;
		
		for(int i=2; i<=k; i++){
			int[] currArr = new int[i+1];
			currArr[0] = 1;
			for(int j=1; j<i; j++){
				 currArr[j] = prevArr[j-1] + prevArr[j];
			}
			currArr[i] = 1;
			prevArr = currArr;
		}
		
		for(int i=0; i<prevArr.length; i++){
			System.out.print(prevArr[i] + ", ");
		}
	}
	
	public static void main(String[] args){
		new PascalsTriangle().sol(2);
	}
}
