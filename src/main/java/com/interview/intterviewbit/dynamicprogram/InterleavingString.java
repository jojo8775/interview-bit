package com.interview.intterviewbit.dynamicprogram;

public class InterleavingString
{
	/**
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
	 * s2.
	 * 
	 * Example, Given:
	 * 
	 * s1 = "aabcc", s2 = "dbbca", When s3 = "aadbbcbcac", return true. When s3
	 * = "aadbbbaccc", return false.
	 * 
	 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
	 */
	public int isInterleave(String a, String b, String c)
	{

		if (a.length() + b.length() != c.length())
		{
			return 0;
		}

		boolean[][] grid = new boolean[a.length() + 1][b.length() + 1];
		grid[0][0] = true;

		// zeroth row
		for (int i = 1; i < grid[0].length; i++)
		{
			if (c.charAt(i - 1) == b.charAt(i - 1))
			{
				grid[0][i] = grid[0][i - 1];
			}
		}

		// zeroth col
		for (int i = 1; i < grid.length; i++)
		{
			if (c.charAt(i - 1) == a.charAt(i - 1))
			{
				grid[i][0] = grid[i - 1][0];
			}
		}

		for (int i = 1; i < grid.length; i++)
		{
			for (int j = 1; j < grid[0].length; j++)
			{
				if (c.charAt(i + j - 1) == a.charAt(i - 1))
				{
					grid[i][j] = grid[i - 1][j];
				}

				if (c.charAt(i + j - 1) == b.charAt(j - 1) && !grid[i][j])
				{
					grid[i][j] = grid[i][j - 1];
				}
			}
		}

		return grid[a.length()][b.length()] ? 1 : 0;
	}
}
