package com.interview.intterviewbit.hash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ColorfulNumber
{
	public int isColorful(int a)
	{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
//		set.add(a);
		
		while(a>0){
			int i = a%10;
			
			if(i==0){
				return 0;
			}
			
			linkedList.addFirst(i);
			a = a/10;
		}
		
		for(int i=0; i<linkedList.size();i++){
			int k = 0;
			for(int j=i; j<linkedList.size();j++){
				int res = 1;
				for(int m = k; m<=j; m++){
					res *= linkedList.get(m);
				}
				
				if(set.contains(res)){
					return 0;
				}
				
				set.add(res);
				k++;
			}
		}
		
		return 1;
	}
	
	public static void main(String[] args){
		int i = new ColorfulNumber().isColorful(23);
		System.out.println(i);
	}
}
