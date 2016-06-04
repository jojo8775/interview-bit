package com.interview.intterviewbit.dynamicprogram;

/**
 * Given two sequences S, T, count number of unique ways in sequence S, to form
 * a subsequence that is identical to the sequence T.
 * 
 * @author jojo
 *
 */
public class DistinctSubsequence
{
	public int distincSubsequence(String S, String T)
	{
		int[][] grid = new int[T.length()][S.length()];
		int count = 0;
		for (int i = 0; i < grid[0].length; i++)
		{
			if (S.charAt(i) == T.charAt(0))
			{
				count++;
			}
			grid[0][i] = count;
		}

		for (int i = 1; i < grid.length; i++)
		{
			for (int j = i; j < grid[0].length; j++)
			{
				if (T.charAt(i) == S.charAt(j))
				{
					grid[i][j] = grid[i - 1][j - 1] + grid[i][j - 1];
				}
				else
				{
					grid[i][j] = grid[i][j - 1];
				}
			}
		}

		return grid[T.length() - 1][S.length() - 1];
	}

	public static void main(String[] args)
	{
		int r = new DistinctSubsequence().distincSubsequence("rabbbit", "rabbit");
		// int r = new DistinctSubsequence().distincSubsequence("abbbc",
		// "abbc");
		System.out.println(r);
	}
}
