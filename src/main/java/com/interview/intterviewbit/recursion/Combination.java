package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination
{
	public List<List<Integer>> find(int n, int k){
		if(n<k){
			return new ArrayList<List<Integer>>();
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		find(n, k, result, new ArrayList<Integer>(), 1);
		
		return result;
	}
	
	private void find(int n, int k, List<List<Integer>> r, List<Integer> s, int nIdx){
		if(k == 0){
			r.add(new ArrayList<Integer>(s));
			return;
		}
		
		for(int i=nIdx; i<=n; i++){
			s.add(i);
			find(n, k-1, r, s, i + 1);
			s.remove(s.size() - 1);
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> r = new Combination().find(4, 4);
		System.out.println(r.size());
	}
}
