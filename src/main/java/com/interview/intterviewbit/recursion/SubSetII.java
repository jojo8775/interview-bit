package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubSetII
{
	public List<List<Integer>> find(List<Integer> nums)
	{
		Collections.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		find(0, new ArrayList<Integer>(), nums, result);

		Collections.sort(result, new Comparator<List<Integer>>()
		{
			@Override
			public int compare(List<Integer> o1, List<Integer> o2)
			{
				int s1 = o1.size(), s2 = o2.size();
				for (int i = 0; i < Math.min(s1, s2); i++)
				{
					if (Integer.compare(o1.get(i), o2.get(i)) != 0)
					{
						return Integer.compare(o1.get(i), o2.get(i));
					}
				}

				return Integer.compare(s1, s2);
			}
		});

		return result;
	}

	private void find(int start, List<Integer> s, List<Integer> rem, List<List<Integer>> r)
	{
		if (start == rem.size())
		{
			List<Integer> temp = new ArrayList<Integer>(s);
			r.add(temp);
			return;
		}

		find(start + 1, new ArrayList<Integer>(s), rem, r);
		s.add(rem.get(start));
		find(start + 1, s, rem, r);
	}

	public List<List<Integer>> subsetsWithDup(List<Integer> S)
	{
		Collections.sort(S);

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>();
		res.add(new ArrayList<Integer>(r));
		r.add(S.get(0));
		res.add(new ArrayList<Integer>(r));
		int pre = S.get(0);
		int count = 1;
		for (int i = 1; i < S.size(); i++)
		{
			int st = 0;
			int sz = res.size();
			if (S.get(i) == pre)
			{
				st = sz - count;
			}
			
			count = 0;
			for (int j = st; j < sz; j++)
			{
				r = new ArrayList<Integer>(res.get(j));
				r.add(S.get(i));
				res.add(new ArrayList<Integer>(r));
				count++;
			}
			pre = S.get(i);
		}
		return res;
	}
	
	public static void main(String[] args)
	{

//		List<List<Integer>> r = new SubSetII().find(Arrays.asList(1, 1, 2));
//		List<List<Integer>> r = new SubSetII().subsetsWithDup(Arrays.asList(1,1,2));
		List<List<Integer>> r = new SubSetII().subsetsWithDup(Arrays.asList(9));

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
