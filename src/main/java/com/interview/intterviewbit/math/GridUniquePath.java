package com.interview.intterviewbit.math;

public class GridUniquePath
{
	/**
	 * This needs to be performed using dynamic programming if there are some
	 * obstructions in this grid. Else this can be solved mathematically.
	 *
	 * if there are total D number of right moves and R number of down moves
	 * then total probability of selection is (D +R)!/(D!R!)
	 */
	public int findPath(int a, int b)
	{
		return fact((a - 1) + (b - 1)) / (fact(a - 1) * fact(b - 1));
	}

	private int fact(int n)
	{
		int f = 1;

		for (int i = 2; i <= n; i++)
		{
			f *= i;
		}

		return f;
	}
}
