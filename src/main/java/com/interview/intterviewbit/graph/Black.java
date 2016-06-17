package com.interview.intterviewbit.graph;

import java.util.Arrays;
import java.util.List;

/*-
Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.

 */
public class Black
{
	public int black(List<String> a)
	{
		int[][] grid = new int[a.size()][a.get(0).length()];

		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (a.get(i).charAt(j) == 'X')
				{
					grid[i][j] = 1;
				}
			}
		}

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		int count = 0;

		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j] == 1 && !visited[i][j])
				{
					dfs(grid, visited, i, j);
					count++;
				}
			}
		}

		return count;
	}

	private void dfs(int[][] grid, boolean[][] visited, int col, int row)
	{
		if (col < 0 || col > grid.length - 1)
		{
			return;
		}

		if (row < 0 || row > grid[0].length - 1)
		{
			return;
		}

		if (grid[col][row] == 0 || visited[col][row])
		{
			return;
		}

		visited[col][row] = true;
		dfs(grid, visited, col - 1, row);
		dfs(grid, visited, col + 1, row);
		dfs(grid, visited, col, row - 1);
		dfs(grid, visited, col, row + 1);
	}

	public static void main(String[] args)
	{
		// int result = new Black().black(Arrays.asList("OOOXOOO", "OOXXOXO",
		// "OXOOOXO"));
		int result = new Black().black(Arrays.asList("XXX", "XXX", "XXX"));
		System.out.println(result);
	}
}
