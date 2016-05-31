package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;

/**
 * Given a 2 * N Grid of numbers, choose numbers such that the sum of the
 * numbers is maximum and no two chosen numbers are adjacent horizontally,
 * vertically or diagonally, and return it.
 * 
 * @author jojo
 *
 */
public class NonAdjacent
{
	public int adjacent(ArrayList<ArrayList<Integer>> a) {
	    int [][] grid = new int[a.size()][a.get(0).size()];
	    
	    grid[1][0] = Math.max(a.get(0).get(0), a.get(1).get(0));
	    
	    for(int i=1; i<a.get(0).size(); i++){
	        grid[0][i] = Math.max(grid[0][i-1], grid[1][i-1]);
	        int tempMax = Math.max(a.get(0).get(i), a.get(1).get(i));
	        grid[1][i] = tempMax + grid[0][i-1];
	    }
	    
	    return Math.max(grid[0][a.get(0).size() - 1], grid[1][a.get(0).size() - 1]);
	}
}
