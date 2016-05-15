package com.interview.intterviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSearch
{
	public int findNum(List<List<Integer>> grid, Integer num){
		int rows = grid.size(), cols = grid.get(0).size(), beg = 0, end = rows*cols - 1;
		
		while(end >= beg){
			int mid = (beg+end)/2;
			int i = mid/cols, j=mid%cols;
			
			if(num == grid.get(i).get(j)){
				return 1;
			}
			
			if(grid.get(i).get(j) > num){
				end = mid - 1;
			}
			else{
				beg = mid + 1;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args){
//		List<List<Integer>> grid = Arrays.asList(createRows(1,3,5,7), 
//												createRows(10,11,16,20), 
//												createRows(24,30,34,50));
//		List<List<Integer>> grid = Arrays.asList(createRows(1,3,5,7));
		List<List<Integer>> grid = Arrays.asList(createRows(3),createRows(29),createRows(36),createRows(63));
		System.out.println(new MatrixSearch().findNum(grid, 8));
	}
	
	private static List<Integer> createRows(int ... args){
		List<Integer> ll = new ArrayList<Integer>();
		for(int i : args){
			ll.add(i);
		}
		return ll;
	}
}
