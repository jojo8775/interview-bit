package com.interview.intterviewbit.dynamicprogram;

import java.util.Arrays;
import java.util.List;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time. 
Example :

Input : 

    [  1 3 2
       4 3 1
       5 6 1
    ]

Output : 8
     1 -> 3 -> 2 -> 1 -> 1
 * @author jojo
 *
 */
public class MinSumPathInMatrix
{
	public int pathSum(List<List<Integer>> a){
	    int[][] grid = new int[a.size()][a.get(0).size()];
	    grid[0][0] = a.get(0).get(0);
	    
	    //zeroth row
	    for(int i=1; i<grid[0].length; i++){
	    	grid[0][i] = a.get(0).get(i) + grid[0][i-1]; 
	    }
	    
	    //zeroth col
	    for(int i=1; i<grid.length; i++){
	    	grid[i][0] = a.get(i).get(0) + grid[i-1][0]; 
	    }
	    
	    for(int i=1; i<grid.length; i++){
	        for(int j=1; j<grid[0].length; j++){
	        	grid[i][j] = a.get(i).get(j) + Math.min(grid[i-1][j], grid[i][j-1]);
	        }
	    }
	    
	    print(grid);
	    return grid[a.size()-1][a.get(0).size()-1];
	}
	
	public static void main(String[] args){
		List<List<Integer>> arr = Arrays.asList(
				Arrays.asList(20, 29, 84, 4, 32, 60, 86, 8, 7, 37),
				Arrays.asList(77, 69, 85, 83, 81, 78, 22, 45, 43, 63),
				Arrays.asList(60, 21, 0, 94, 59, 88, 9, 54, 30, 80),
				Arrays.asList(40, 78, 52, 58, 26, 84, 47, 0, 24, 60),
				Arrays.asList(40, 17, 69, 5, 38, 5, 75, 59, 35, 26),
				Arrays.asList(64, 41, 85, 22, 44, 25, 3, 63, 33, 13),
				Arrays.asList(2, 21, 39, 51, 75, 70, 76, 57, 56, 22),
				Arrays.asList(31, 45, 47, 100, 65, 10, 94, 96, 81, 14));
		
		int r = new MinSumPathInMatrix().pathSum(arr);
		System.out.println(r);
	}
	
	private static void print(int[][] arr){
		for(int[] a : arr){
			for(int i: a){
				System.out.print(i + ", ");
			}
			
			System.out.println();
		}
	}
}
