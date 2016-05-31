package com.interview.intterviewbit.dynamicprogram;

import java.util.Arrays;
import java.util.List;


public class MinimumJumps
{
	public int minJumps(List<Integer> nums)
	{

		int[] arr = new int[nums.size()];
		arr[0] = 0;

		if (nums.get(0) >= (nums.size() - 1))
		{
			return 1;
		}

		for (int i = 1; i < nums.size(); i++)
		{
			arr[i] = -1;

			for (int j = 0; j < i; j++)
			{
				int diff = i - j;
				if (nums.get(j) >= diff)
				{
					if (arr[i] == -1 || arr[i] > (arr[j] + 1))
					{
						arr[i] = arr[j] + 1;
					}
				}
			}
			if (arr[i] == -1)
			{
				return -1;
			}

			if (nums.get(i) >= (nums.size() - i - 1))
			{
				arr[arr.length - 1] = arr[i] + 1;
				break;
			}
		}

		return arr[nums.size() - 1];
	}

	public int greedyApproach(List<Integer> nums)
	{
		if (nums.size() < 2)
		{
			return 0;
		}

		int maxPos = nums.get(0), currMaxPos = maxPos, steps = 1;

		for (int i = 1; i <= maxPos; i++)
		{
			if (i == nums.size() - 1)
			{
				return steps;
			}

			currMaxPos = Math.max(currMaxPos, i + nums.get(i));
			if (i == maxPos)
			{
				if (currMaxPos <= maxPos)
				{
					return -1;
				}

				maxPos = currMaxPos;
				steps++;
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{
		// int r = new MinimumJumps().minJumps(Arrays.asList(0, 46, 46, 0, 2,
		// 47, 1, 24, 45, 0, 0, 24, 18, 29, 27, 11, 0, 0, 40, 12, 4, 0, 0, 0,
		// 49, 42, 13, 5, 12, 45, 10, 0, 29, 11, 22, 15, 17, 41, 34, 23, 11, 35,
		// 0, 18, 47, 0, 38, 37, 3, 37, 0, 43, 50, 0, 25, 12, 0, 38, 28, 37, 5,
		// 4, 12, 23, 31, 9, 26, 19, 11, 21, 0, 0, 40, 18, 44, 0, 0, 0, 0, 30,
		// 26, 37, 0, 26, 39, 10, 1, 0, 0, 3, 50, 46, 1, 38, 38, 7, 6, 38, 27,
		// 7, 25, 30, 0, 0, 36, 37, 6, 39, 40, 32, 41, 12, 3, 44, 44, 39, 2, 26,
		// 40, 36, 35, 21, 14, 41, 48, 50, 21, 0, 0, 23, 49, 21, 11, 27, 40, 47,
		// 49));
		int r = new MinimumJumps().minJumps(Arrays.asList(2, 3, 1, 1, 4));
		System.out.println(r);
	}
}
