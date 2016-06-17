package com.interview.intterviewbit.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, return the highest product possible by
 * multiplying 3 numbers from the array
 * 
 * Input:
 * 
 * array of integers e.g {1, 2, 3} NOTE: Solution will fit in a 32-bit signed
 * integer Example:
 * 
 * [0, -1, 3, 100, 70, 50]
 * 
 * => 70*50*100 = 350000
 * 
 * @author jojo
 *
 */
public class HighestProduct
{
	public int maxp3(List<Integer> a)
	{
		Collections.sort(a);

		int n = a.size() - 1, r1 = a.get(n) * a.get(n - 1) * a.get(n - 2), r2 = a.get(0) * a.get(1) * a.get(n);

		return Math.max(r1, r2);
	}

	public static void main(String[] args)
	{
		int result = new HighestProduct().maxp3(Arrays.asList(-1, -2, -3, -4, -5));
		System.out.println(result);
	}
}
