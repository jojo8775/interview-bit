package com.interview.intterviewbit.arrays;

public class SpiralGrid
{
	private void sol(int a)
	{
		int top = 0, bottom = a - 1, left = 0, right = a - 1, count = 1;
		int[][] grid = new int[a][a];

		while (top < bottom && left < right)
		{
			for (int i = left; i <= right; i++)
			{
				grid[top][i] = count++;
			}
			top++;

			for (int i = top; i <= bottom; i++)
			{
				grid[i][right] = count++;
			}

			right--;
			for (int i = right; i >= left; i--)
			{
				grid[bottom][i] = count++;
			}

			bottom--;
			for (int i = bottom; i >= top; i--)
			{
				grid[i][left] = count++;
			}

			left++;
		}
		
		if(a%2 > 0){
			grid[a/2][a/2] = count;
		}

		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid.length; j++){
				System.out.print(grid[i][j] + ", ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		new SpiralGrid().sol(1);
	}
}
