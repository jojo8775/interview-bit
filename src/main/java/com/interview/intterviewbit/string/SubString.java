package com.interview.intterviewbit.string;

public class SubString
{
	public int subString(String a, String b){
		int[] arr = indexPattern(b);
		int i=0,j=0;
		
		while(j<a.length() && i<b.length()){
			if(b.charAt(i)==a.charAt(j)){
				i++;
				j++;
			}
			else if(i!=0){
				i = arr[i-1];
			}
			else{
				j++;
			}
		}
		
		if(i == b.length()){
			return j-b.length() + 1;
		}
		return -1;
	}
	
	private int[] indexPattern(String s){
		int[] arr = new int[s.length()];
		
		int  i=1,j=0,n=s.length();
		while(i<n){
			if(s.charAt(j)==s.charAt(i)){
				arr[i++] = arr[j++] + 1;
			}
			else if(j==0){
				arr[i++] = j;
			}
			else{
				j = arr[--j];
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args){
		System.out.println(new SubString().subString("aab", "abb"));
	}
}
