package com.interview.intterviewbit.dynamicprogram;

public class M
{
	public class Solution
	{
		public int isMatch(final String s, final String p)
		{
			boolean[][] d = new boolean[s.length() + 1][p.length() + 1];
			d[0][0] = true;

			for (int i = 0; i < p.length(); ++i)
			{
				char current = p.charAt(i);
				if (current == '*')
				{
					for (int j = 0; j < s.length(); ++j)
					{
						d[j + 1][i + 1] = d[j + 1][i - 1];
					}
					for (int j = 0; j < s.length(); ++j)
					{
						if ((p.charAt(i - 1) == '.') || (p.charAt(i - 1) == s.charAt(j)))
						{
							d[j + 1][i + 1] = d[j + 1][i + 1] || d[j][i - 1] || d[j][i + 1];
						}
					}
				}
				
				else if (current == '.')
				{
					for (int j = s.length() - 1; j >= 0; --j)
					{
						d[j + 1][i + 1] = d[j][i];
					}
				} 
				
				
				else
				{
					for (int j = 0; j < s.length(); ++j)
					{
						if (s.charAt(j) == p.charAt(i))
						{
							d[j + 1][i + 1] = d[j][i];
						}
					}
				}
			}

			return d[s.length()][p.length()] ? 1 : 0;
		}
	}
}
