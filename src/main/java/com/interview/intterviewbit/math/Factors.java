package com.interview.intterviewbit.math;

import java.util.ArrayList;
import java.util.List;

public class Factors
{
	public void findFactors(int a){
		List<Integer> f = new ArrayList<Integer>();
		f.add(1);
		for(int i=2; i<=Math.sqrt(a); i++){
			if(a%i == 0){
				f.add(i);
				f.add(a/i);
			}
		}
		
		f.add(a);
		print(f);
	}
	
	private void print(List<Integer> f){
		for(int i : f){
			System.out.print(i + ", ");
		}
	}
	
	public static void main(String[] args){
		new Factors().findFactors(24);
	}
}
