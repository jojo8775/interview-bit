package com.interview.intterviewbit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum
{
	public List<List<Integer>> fourSum(List<Integer> nums, int target){
		Collections.sort(nums);
		
		Set<List<Integer>> hashSet = new HashSet<List<Integer>>();
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i=0; i<nums.size() - 3; i++){
			for(int j=i+1; j<nums.size()-2; j++){
				int k = j+1, l = nums.size() - 1;
				while(l > k){
					int temp = nums.get(i) + nums.get(j) + nums.get(k) + nums.get(l);
					if(temp == target){
						List<Integer> ll = new ArrayList<Integer>();
						ll.add(nums.get(i));
						ll.add(nums.get(j));
						ll.add(nums.get(k));
						ll.add(nums.get(l));
						
						if(!hashSet.contains(ll)){
							hashSet.add(ll);
							result.add(ll);
						}
						l--;
						k++;
					}
					else if(temp > target){
						l--;
					}
					else{
						k++;
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		List<List<Integer>> rr = new FourSum().fourSum(Arrays.asList(1, 0, -1, 0, -2, 2), 0);
		
		for(List<Integer> r : rr){
			for(int i : r){
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}
}
