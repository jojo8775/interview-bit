package com.interview.intterviewbit.math;

import java.util.Arrays;

public class Permutation
{
	public void permute(String s){
		permute("", s);
	}
	
	private void permute(String soFar, String rest){
		if(rest.isEmpty()){
			System.out.println(soFar);
			return;
		}
		
		for(int i=0; i<rest.length(); i++){
			String rem = rest.substring(0,i) + rest.substring(i+1, rest.length());
			permute(soFar + rest.charAt(i), rem);
		}
	}
	
	public static void main(String[] args){
		char[] c = "DTNGJPURFHYEW".toCharArray();
		Arrays.sort(c);
		
		new Permutation().permute(String.valueOf(c));
	}
}
