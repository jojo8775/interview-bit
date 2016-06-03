package com.interview.intterviewbit.dynamicprogram;

/**
 * Given two words A and B, find the minimum number of steps required to convert
 * A to B. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character Delete a character Replace a character Example : edit
 * distance between "Anshuman" and "Antihuman" is 2.
 * 
 * Operation 1: Replace s with t. Operation 2: Insert i.
 * 
 * @author jojo
 *
 */
public class MinEdit
{
	public int minDistance(String a, String b)
	{
		if (a.isEmpty())
		{
			return b.length();
		} else if (b.isEmpty())
		{
			return a.length();
		}

		int[][] grid = new int[a.length() + 1][b.length() + 1];

		// zeroth row
		for (int i = 0; i <= b.length(); i++)
		{
			grid[0][i] = i;
		}

		// zeroth col
		for (int i = 0; i <= a.length(); i++)
		{
			grid[i][0] = i;
		}

		for (int i = 1; i <= a.length(); i++)
		{
			for (int j = 1; j <= b.length(); j++)
			{
				// no edit needed refer diagonal
				if (a.charAt(i - 1) == b.charAt(j - 1))
				{
					grid[i][j] = grid[i - 1][j - 1];
				} else
				{
					int minEdit = Math.min(grid[i - 1][j - 1], Math.min(grid[i][j - 1], grid[i - 1][j]));
					grid[i][j] = minEdit + 1;
				}
			}
		}

		return grid[a.length()][b.length()];
	}
}
