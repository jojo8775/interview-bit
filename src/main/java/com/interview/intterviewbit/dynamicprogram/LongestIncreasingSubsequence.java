package com.interview.intterviewbit.dynamicprogram;

import java.util.List;

/**
 * Find the longest increasing subsequence of a given sequence / array.
 * 
 * In other words, find a subsequence of array in which the subsequence’s
 * elements are in strictly increasing order, and in which the subsequence is as
 * long as possible. This subsequence is not necessarily contiguous, or unique.
 * In this case, we only care about the length of the longest increasing
 * subsequence.
 * 
 * Example :
 * 
 * Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15] Output : 6 The
 * sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13,
 * 15]
 * 
 * @author jojo
 *
 */
public class LongestIncreasingSubsequence
{
	public int lis(final List<Integer> a)
	{
		if (a.isEmpty())
		{
			return 0;
		}

		int[] arr = new int[a.size()];
		arr[0] = 1;

		int maxLength = 1;

		for (int i = 1; i < a.size(); i++)
		{
			arr[i] = 1;
			for (int j = 0; j < i; j++)
			{
				if (a.get(j) < a.get(i))
				{
					arr[i] = Math.max(arr[i], arr[j] + 1);

					maxLength = Math.max(maxLength, arr[i]);
				}
			}
		}

		return maxLength;
	}

	// recursive sol
	private int max_ref = 1;

	public int rec(int arr[], int n)
	{
		// base case
		if (n == 1)
			return 1;

		// 'max_ending_here' is length of LIS ending with arr[n-1]
		int res, max_ending_here = 1;

		/*
		 * Recursively get all LIS ending with arr[0], arr[1] ... arr[n-2]. If
		 * arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
		 * to be updated, then update it
		 */
		for (int i = 1; i < n; i++)
		{
			System.out.println("i == " + i + " arr[i] == " + arr[i]);
			System.out.println("i-1 == " + (i - 1) + " arr[i-1] == " + arr[i - 1]);
			System.out.println("n == " + n + " arr[n-1] == " + arr[n - 1]);
			System.out.println("--------------------------------------");
			res = rec(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		// Compare max_ending_here with the overall max. And
		// update the overall max if needed
		if (max_ref < max_ending_here)
			max_ref = max_ending_here;

		// Return length of LIS ending with arr[n-1]
		return max_ending_here;
	}

	
	public static void main(String[] args){
		int[] arr = {5,1,3,2,4};
		int  r = new LongestIncreasingSubsequence().rec(arr, 5);
		System.out.println(r);
	}
}
