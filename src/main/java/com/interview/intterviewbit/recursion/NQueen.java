package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen
{
	private List<List<Integer>> find(int num){
		int[] arr = new int[num];
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		find(arr, result, 0);
		
		return result;
	}
	
	private void find(int[] arr, List<List<Integer>> result, int pos){
		if(pos == arr.length){
			List<Integer> temp = new ArrayList<Integer>();
			for(int i : arr){
				temp.add(i);
			}
			
			result.add(temp);
			return;
		}
		
		for(int i=0; i<arr.length; i++){
			arr[pos] = i;
			if(valid(arr, pos)){
				find(arr, result, pos+1);
			}
		}
	}
	
	private boolean valid(int[] arr, int pos){
		for(int i=0; i<pos; i++){
			int diff = Math.abs(arr[i] - arr[pos]);
			if(diff == 0 || diff == pos - i){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		List<List<Integer>> result = new NQueen().find(4);
		System.out.println(result.size());
		
		for(List<Integer> l : result){
			for(int i : l){
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}
}
