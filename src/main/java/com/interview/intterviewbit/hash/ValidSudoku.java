package com.interview.intterviewbit.hash;

import java.util.Arrays;
import java.util.List;

public class ValidSudoku
{
	public int isValidSudoku(final List<String> a)
	{
		if (a.size() != 9)
		{
			return 0;
		}

		for (String s : a)
		{
			if (s.length() != 9)
			{
				return 0;
			}
		}

		// checkrows
		for (String s : a)
		{
			boolean[] b = new boolean[9];
			for (int i = 0; i < 9; i++)
			{
				if (s.charAt(i) != '.')
				{
					if (b[Character.getNumericValue(s.charAt(i)) - 1])
					{
						return 0;
					}
					b[Character.getNumericValue(s.charAt(i)) - 1] = true;
				}
			}
		}

		// check cols
		for (int i = 0; i < 9; i++)
		{
			boolean[] b = new boolean[9];
			for (int j = 0; j < 9; j++)
			{
				if (a.get(j).charAt(i) != '.')
				{
					if (b[Character.getNumericValue(a.get(j).charAt(i)) - 1])
					{
						return 0;
					}
					b[Character.getNumericValue(a.get(j).charAt(i)) - 1] = true;
				}
			}
		}

		// check grid
		for (int i = 0; i < 9; i++)
		{
			boolean[] b = new boolean[9];
			for (int j = i / 3 * 3; j < i / 3 * 3 + 3; j++)
			{
				for (int k = i % 3 * 3; k < i % 3 * 3 + 3; k++)
				{
					if (a.get(j).charAt(k) != '.')
					{
						if (b[Character.getNumericValue(a.get(j).charAt(k)) - 1])
						{
							return 0;
						}

						b[Character.getNumericValue(a.get(j).charAt(k)) - 1] = true;
					}
				}
			}
		}

		return 1;
	}

	public static void main(String[] args)
	{
		int r = new ValidSudoku().isValidSudoku(Arrays.asList("....5..1.", ".4.3.....", ".....3..1", "8......2.",
				"..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"));
		
		System.out.println(r);
	}
}
