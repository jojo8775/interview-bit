package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;

/**
 * There are N coins (Assume N is even) in a line. Two players take turns to
 * take a coin from one of the ends of the line until there are no more coins
 * left. The player with the larger amount of money wins. Assume that you go
 * first.
 * 
 * Write a program which computes the maximum amount of money you can win.
 * 
 * Example:
 * 
 * suppose that there are 4 coins which have value 1 2 3 4 now you are first so
 * you pick 4 then in next term next person picks 3 then you pick 2 and then
 * next person picks 1 so total of your money is 4 + 2 = 6 next/opposite person
 * will get 1 + 3 = 4 so maximum amount of value you can get is 6
 * 
 * @author jojo
 *
 */
public class CoinsInLine{
	public int maxcoin(ArrayList<Integer> a) {
	    Entry[][] grid = new Entry[a.size()][a.size()];
	    
	    // initializing use case when there is only one entry
	    for(int i=0; i<grid.length; i++){
	        grid[i][i] = new Entry(a.get(i), 0);
	    }
	    
	    for(int i=1; i<grid.length; i++){
	        int k = 0;
	        for(int j=i; j<grid.length; j++){
	            int s1 = grid[k][k].first + grid[k+1][j].second;
	            int s2 = grid[j][j].first + grid[k][j-1].second;
	            
	            if(s1 > s2){
	                grid[k][j] = new Entry(s1, grid[k+1][j].first);
	            }
	            else{
	                grid[k][j] = new Entry(s2, grid[k][j-1].first);
	            }
	            
	            k++;
	        }
	    }
	    
	    return grid[0][a.size()-1].first;
	}
	
	private static class Entry{
	    public int first;
	    public int second;
	    
	    public Entry(int first, int second){
	        this.first = first;
	        this.second = second;
	    }
	}
}
