package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubSet
{
	public List<List<Integer>> subSet(List<Integer> nums)
	{
		List<List<Integer>> r = new ArrayList<List<Integer>>();

		Collections.sort(nums);

		subSet(new ArrayList<Integer>(), nums, 0, r);

		Collections.sort(r, new Comparator<List<Integer>>()
		{
			@Override
			public int compare(List<Integer> o1, List<Integer> o2)
			{
				int l1 = o1.size(), l2 = o2.size();
				
				for(int i=0; i<Math.min(l1, l2); i++ )
				{
					if(Integer.compare(o1.get(i), o2.get(i)) != 0){
						return Integer.compare(o1.get(i), o2.get(i));
					}
				}
				
				return Integer.compare(l1, l2);
			}
		});

		return r;
	}

	private void subSet(List<Integer> sofar, List<Integer> nums, int idx, List<List<Integer>> r)
	{
		if (idx == nums.size())
		{
			List<Integer> temp = new ArrayList<Integer>(sofar);
			r.add(temp);
//			sofar.clear();
			return;
		}

		subSet(new ArrayList<Integer>(sofar), nums, idx + 1, r);
		sofar.add(nums.get(idx));
		subSet(sofar, nums, idx + 1, r);
	}

	public static void main(String[] args)
	{

		List<List<Integer>> r = new SubSet().subSet(Arrays.asList(1, 2, 3));

		for (List<Integer> l : r)
		{
			for (int i : l)
			{
				System.out.print(i + ", ");
			}

			System.out.println();
		}
	}
}
