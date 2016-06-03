package com.interview.intterviewbit.dynamicprogram;

public class ArrangeII
{
	public int find(String horses, int stables){
		int[][] grid = new int[stables + 1][horses.length() + 1];
		
		for(int i=1; i<=horses.length(); i++){
			grid[1][i] = findProd(horses, 0, i-1);
		}
		
		for(int i = 2; i<=stables; i++){
			for(int j=i; j<=horses.length(); j++){
				int min = Integer.MAX_VALUE;
				for(int k = i-1; k<=j-1; k++){
					grid[i][j] = Math.min(grid[i-1][k] + findProd(horses, k, j-1), min);
					min = grid[i][j];
				}
			}
		}
		
		return grid[stables][horses.length()];
	}
	
	private int findProd(String a, int idx1, int idx2){
		int white = 0, black = 0;
		for(int i=idx1; i<=idx2; i++){
			if(a.charAt(i) == 'W'){
				white++;
			}
			else{
				black ++;
			}
		}
		
		return white * black;
	}
	
	public static void main(String[] args){
		int r = new ArrangeII().find("BWWWBB", 2);
		System.out.println(r);
	}
}
