package com.interview.intterviewbit.dynamicprogram;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' : Matches any single character. '*' : Matches any sequence of characters
 * (including the empty sequence). The matching should cover the entire input
 * string (not partial).
 * 
 * The function prototype should be:
 * 
 * int isMatch(const char *s, const char *p) Examples :
 * 
 * isMatch("aa","a") → 0 isMatch("aa","aa") → 1 isMatch("aaa","aa") → 0
 * isMatch("aa", "*") → 1 isMatch("aa", "a*") → 1 isMatch("ab", "?*") → 1
 * isMatch("aab", "c*a*b") → 0
 * 
 * @author jojo
 *
 */
public class RegularExpression
{
	public int isMatch(final String s, final String p)
	{
		boolean[][] grid = new boolean[s.length() + 1][p.length() + 1];
		grid[0][0] = true;

		// for the zeroth row
		for (int i = 1; i < grid[0].length; i++)
		{
			if (p.charAt(i - 1) == '*' || p.charAt(i - 1) == ' ')
			{
				grid[0][i] = grid[0][i - 1];
			}
		}

		// for the zeroth col
		for (int i = 1; i < grid.length; i++)
		{
			if (s.charAt(i - 1) == '*' || s.charAt(i - 1) == ' ')
			{
				grid[i][0] = grid[i - 1][0];
			}
		}

		for (int i = 1; i < grid.length; i++)
		{
			for (int j = 1; j < grid[0].length; j++)
			{
				if (s.charAt(i - 1) == p.charAt(j - 1) || s.charAt(i - 1) == '?' || p.charAt(j - 1) == '?')
				{
					grid[i][j] = grid[i - 1][j - 1];
				}
				else if (s.charAt(i - 1) == '*' || p.charAt(j - 1) == '*')
				{
					grid[i][j] = grid[i - 1][j - 1] || grid[i - 1][j] || grid[i][j - 1];
				}
			}
		}

		return grid[s.length()][p.length()] ? 1 : 0;
	}
}
