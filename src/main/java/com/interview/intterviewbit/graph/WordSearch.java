package com.interview.intterviewbit.graph;

import java.util.ArrayList;

/*-
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell. 
The same letter cell may be used more than once.

Example :

Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
Note that 1 corresponds to true, and 0 corresponds to false.
 */
public class WordSearch
{
	public int exist(ArrayList<String> a, String b) {
	    char[][] grid = new char[a.size()][];
	    
	    //creating the grid
	    for(int i=0;i<a.size(); i++){
	        grid[i] = new char[a.get(i).length()];
	        for(int j=0; j<a.get(i).length(); j++){
	            grid[i][j] = a.get(i).charAt(j);
	        }
	    }
	    
	    // searching for string
	    for(int i=0; i<grid.length; i++){
	        for(int j=0; j<grid[i].length; j++){
	            if(grid[i][j] == b.charAt(0)){
	                if(find(grid, b, i, j, 0)){
	                    return 1;
	                }
	            }
	        }
	    }
	    
	    return 0;
	}
	
	private boolean find(char[][] grid, String b, int col, int row, int idx){
	    // went out of grid
	    if(col < 0 || col >= grid.length || row < 0 || row >= grid[col].length){
	        return false;
	    }
	    
	    if(grid[col][row] == b.charAt(idx)){
	        char temp = grid[col][row];
	        // Dont need this logic as repeatation of characters are allowed.
	        // grid[col][row] = '#';
	        
	        if(idx == b.length() - 1){
	            return true;
	        }
	        else if(find(grid, b, col + 1, row, idx + 1) 
	            || find(grid, b, col - 1, row, idx + 1)
	            || find(grid, b, col, row + 1, idx + 1)
	            || find(grid, b, col, row - 1, idx + 1)){
	                
	            return true;
	        }
	        
	       // grid[col][row] = temp;
	    }
	    
	    return false;
	}
}
