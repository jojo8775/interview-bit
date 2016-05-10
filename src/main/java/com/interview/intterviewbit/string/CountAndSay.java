package com.interview.intterviewbit.string;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay
{
	public String findSeq(int n)
	{
		if(n==1){
			return "1";
		}
		
		List<Integer> pattern = new ArrayList<Integer>();
		pattern.add(1);
		pattern.add(1);
		
		for(int i=3; i<=n; i++){
			List<Integer> temp = new ArrayList<Integer>();
			int count = 1, num, numCount = 1;
			while(count < pattern.size()){
				num = pattern.get(count);
				if(num != pattern.get(count-1)){
					temp.add(numCount);
					temp.add(pattern.get(count-1));
					numCount = 1;
				}
				else{
					numCount ++;
				}
				
				count++;
			}
			
			temp.add(numCount);
			temp.add(pattern.get(count - 1));
			
			pattern = temp;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : pattern){
			sb.append(i);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(new CountAndSay().findSeq(4));
	}
}
