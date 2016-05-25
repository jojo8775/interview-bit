package com.interview.intterviewbit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum
{
	List<Integer> find(List<Integer> nums, int t)
	{
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		int ref1 = Integer.MAX_VALUE, ref2 = Integer.MAX_VALUE;

		for (int i = 0; i < nums.size(); i++)
		{
			int n = nums.get(i);

			if (map.containsKey(t - n))
			{
				int i2 = Integer.MAX_VALUE;
				for (int x : map.get(t - n))
				{
					i2 = Math.min(i2, x);
				}

				int i1 = i;

				if (i2 < i1)
				{
					i1 = i2;
					i2 = i;
				}

				if (i2 < ref2)
				{
					ref1 = i1;
					ref2 = i2;
				}
				else if (i2 == ref2 && i1 < ref1)
				{
					ref1 = i1;
				}
			}
			else
			{
				if(!map.containsKey(n)){
					map.put(n, new ArrayList<Integer>());
				}
				List<Integer> list = map.get(n);
				list.add(i);
			}
		}

		if (ref1 == Integer.MAX_VALUE)
		{
			return new ArrayList<Integer>();
		}

		List<Integer> result = new ArrayList<Integer>(2);
		result.add(ref1);
		result.add(ref2);

		return result;
	}

	public static void main(String[] args)
	{
		// List<Integer> r = new TwoSum().find(Arrays.asList(2,7,11,15), 9);
		List<Integer> r = new TwoSum().find(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1,
				-4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8), -3);

		for (int i : r)
		{
			System.out.print(i + ", ");
		}
	}
}
