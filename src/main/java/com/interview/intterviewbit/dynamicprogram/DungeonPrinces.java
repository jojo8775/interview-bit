package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;

/**
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0’s) or
 * contain magic orbs that increase the knight’s health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * Write a function to determine the knight’s minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path
 * 
 * RIGHT-> RIGHT -> DOWN -> DOWN.
 * 
 * 
 * @author jojo
 *
 */
public class DungeonPrinces
{
	public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a)
	{
		int[][] grid = new int[a.size()][a.get(0).size()];
		int m = grid.length - 1, n = grid[0].length - 1;

		// minimum health required for the last step
		grid[m][n] = Math.max(1 - a.get(m).get(n), 1);

		// minimum health for last row
		for (int i = n - 1; i >= 0; i--)
		{
			grid[m][i] = Math.max(grid[m][i + 1] - a.get(m).get(i), 1);
		}

		// minimum health for last col
		for (int i = m - 1; i >= 0; i--)
		{
			grid[i][n] = Math.max(grid[i + 1][n] - a.get(i).get(n), 1);
		}

		// rest of the calculation
		for (int i = m - 1; i >= 0; i--)
		{
			for (int j = n - 1; j >= 0; j--)
			{
				int down = Math.max(grid[i + 1][j] - a.get(i).get(j), 1);
				int right = Math.max(grid[i][j + 1] - a.get(i).get(j), 1);

				grid[i][j] = Math.min(down, right);
			}
		}

		return grid[0][0];
	}
}
