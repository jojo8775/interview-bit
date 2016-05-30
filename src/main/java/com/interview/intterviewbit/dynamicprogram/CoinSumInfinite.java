package com.interview.intterviewbit.dynamicprogram;

import java.util.List;

public class CoinSumInfinite
{
	public int find(List<Integer> coins, int sum)
	{
		int[][] grid = new int[coins.size() + 1][sum + 1];

		for (int i = 1; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (j == 0)
				{
					grid[i][j] = 1;
				}
				else if (coins.get(i - 1) > j)
				{
					grid[i][j] = grid[i - 1][j];
				}
				else
				{
					grid[i][j] = grid[i - 1][j] + grid[i][j - coins.get(i - 1)];
				}
			}
		}

		return grid[coins.size()][sum];
	}
}
