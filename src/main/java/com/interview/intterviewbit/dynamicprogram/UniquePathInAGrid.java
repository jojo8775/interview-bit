package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;

/**
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
 * @author jojo
 *
 */
public class UniquePathInAGrid
{
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
	    if(a.get(0).get(0) == 1){
	        return 0;
	    }
	    
	    int[][] grid = new int[a.size()][a.get(0).size()];
	    grid[0][0] = 1;
	    
	    //zeroth row
	    for(int i=1; i<grid[0].length; i++){
	        if(a.get(0).get(i) != 1){
	            grid[0][i] = grid[0][i-1];
	        }
	    }
	    
	    //zerth col
	    for(int i=1; i<grid.length; i++){
	        if(a.get(i).get(0) != 1){
    	        grid[i][0] = grid[i-1][0];
	        }
	    }
	    
	    // other path
	    for(int i=1; i<grid.length; i++){
	        for(int j=1; j<grid[0].length; j++){
	            // if there is no obstruction
	            if(a.get(i).get(j) != 1){
	                grid[i][j] = grid[i-1][j] + grid[i][j-1];
	            }
	        }
	    }
	    
	    return grid[a.size() - 1][a.get(0).size() - 1];
	}
}
