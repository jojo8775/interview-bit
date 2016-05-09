package com.interview.intterviewbit.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortedPermutationRank
{
	public int findRank(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		
		Set<Character> visited = new HashSet<Character>();
		
		int pos= 0;
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			int j=0, actualCount = 0;
			while(c[j] != ch){
				if(!visited.contains(c[j])){
					actualCount++;
				}
				j++;
			}
			
			visited.add(c[j]);
			
			pos += (actualCount*(fact(s.length() - (i+1)))) % 1000003;
		}
		
		return (pos + 1) % 1000003;
	}
	
	private int fact(int n){
		if(n==0){
			return 0;
		}
		
		int fact = 1;
		for(int i=2; i<=n; i++){
			fact = (fact * i) % 1000003; 
		}
		
		return fact;
	}

	/**
	 * abc
	 * acb
	 * bac
	 * bca
	 * cab
	 * cba
	 */
	public static void main(String[] args){
		int p = new SortedPermutationRank().findRank("DTNGJPURFHYEW");
		System.out.println(p);
	}
	
}
