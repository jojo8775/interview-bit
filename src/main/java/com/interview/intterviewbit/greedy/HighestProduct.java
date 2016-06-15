package com.interview.intterviewbit.greedy;

import java.util.LinkedList;

public class HighestProduct{
	public int findHighedProduct(int[] arr, int num){
		LinkedList<Integer> minList = new LinkedList<Integer>(), maxList = new LinkedList<Integer>();
		
		for(int i=0; i<arr.length; i++){
			if(arr[i] < 0){
				if(maxList.size() == 2){
					if(maxList.get(0) > arr[i]){
						maxList.set(0, arr[i]);
						heapifyMax(maxList, 0);
					}
				}
				else{
					maxList.addFirst(arr[i]);
					heapifyMax(maxList, 0);
				}
			}
			else if(arr[i] > 0){
				if(minList.size() == 3){
					if(minList.get(0) < arr[i]){
						minList.set(0, arr[i]);
						heapifyMin(minList, 0);
					}
				}
				else{
					minList.addFirst(arr[i]);
					heapifyMin(minList, 0);
				}
			}
		}
		
		int result2 = 1;
		for(int i : maxList){
			result2 *= i;
		}
		
		if(!minList.isEmpty()){
			result2 *= minList.get(minList.size() - 1);
		}
		
		int result1 = 1;
		for(int i : minList){
			result1 *= i;
		}
		
		return Math.max(result1,result2);
	}
	
	private void heapifyMin(LinkedList<Integer> list, int idx){
		int twiceIdx = 2*idx + 1, twiceIdxPlusOne = 2*idx + 2, minIdx = idx;
		
		if(twiceIdx < list.size() && list.get(twiceIdx) < list.get(idx)){
			minIdx = twiceIdx;
		}
		
		if(twiceIdxPlusOne < list.size() && list.get(twiceIdxPlusOne) < list.get(minIdx)){
			minIdx = twiceIdxPlusOne;
		}
		
		if(minIdx != idx){
			swap(list, idx, minIdx);
			heapifyMin(list, minIdx);
		}
	}
	
	private void heapifyMax(LinkedList<Integer> list, int idx){
		int twiceIdx = 2*idx + 1, twiceIdxPlusOne = 2*idx + 2, maxIdx = idx;
		
		if(twiceIdx < list.size() && list.get(twiceIdx) > list.get(idx)){
			maxIdx = twiceIdx;
		}
		
		if(twiceIdxPlusOne < list.size() && list.get(twiceIdxPlusOne) > list.get(maxIdx)){
			maxIdx = twiceIdxPlusOne;
		}
		
		if(maxIdx != idx){
			swap(list, idx, maxIdx);
			heapifyMax(list, maxIdx);
		}
	}
	
	private void swap(LinkedList<Integer> list, int idx1, int idx2){
		int temp = list.get(idx1);
		list.set(idx1, list.get(idx2));
		list.set(idx2, temp);
	}
	
	public static void main(String[] args){
//		int[] arr = {0, -1, 3, 100, 70, 50};
		int[] arr = {-1, -2, -3, -4, -5};
		 
		
		int result = new HighestProduct().findHighedProduct(arr, 3);
		System.out.println(result);
	}
}
