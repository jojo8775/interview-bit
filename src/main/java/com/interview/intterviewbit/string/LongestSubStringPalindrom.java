package com.interview.intterviewbit.string;

public class LongestSubStringPalindrom
{
	public int subString(String str){
		if(str.length() < 2){
			return str.length();
		}
		
		int[][] grid = new int[str.length()][str.length()];
		
		for(int i=0; i<grid.length; i++){
			grid[i][i] = 1;
		}
		
		for(int i=0; i<grid.length; i++){
			int k = 0;
			for(int j=i+1; j<grid.length; j++){
				if(str.charAt(k) == str.charAt(j)){
					if((j-1)-(k+1)+1 == grid[k+1][j-1]){
						grid[k][j] = 2 + grid[k+1][j-1];
					}
					else{
						grid[k][j] = Math.max(grid[k+1][j], grid[k][j-1]);
					}
				}
				else{
					grid[k][j] = Math.max(grid[k+1][j], grid[k][j-1]);
				}
				k++;
			}
		}
		
		print(grid);
		
		int i=0, j=0, max = grid[0][str.length()-1];
		while(grid[0][j] < max){
			j++;
		}

		i = j - max + 1;
		
		System.out.println(str.substring(i,j+1));
		
		return grid[0][str.length()-1];
	}
	
	private static void print(int[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				System.out.print(arr[i][j] + " , ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args){
//		int r = new LongestSubStringPalindrom().subString("geeksskeeg");
//		int r = new LongestSubStringPalindrom().subString("abb");
		int r = new LongestSubStringPalindrom().subString("abacdfgdcaba");
		System.out.println(r);
	}
}
