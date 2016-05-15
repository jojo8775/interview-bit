package com.interview.intterviewbit.topointer;

import java.util.List;

public class DiffK
{
	public int ifExist(List<Integer> list, int k){
		int i=0, j = i+1, n=list.size();
		while(i<n && j<n){
			int sum = list.get(j) - list.get(i);
			if(sum == k){
				return 1;
			}
			
			if(sum < k){
				j++;
			}
			else{
				i++;
			}
		}
		
		return 0;
	}	
}
