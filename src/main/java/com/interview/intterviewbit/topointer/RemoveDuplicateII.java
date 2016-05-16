package com.interview.intterviewbit.topointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateII
{
	public int removeDuplicates(List<Integer> a)
	{
		int i = 0, j = 1, cur = 1, n = a.size();

		while (j < n)
		{
			if (a.get(i).equals(a.get(j)))
			{
				cur++;
				if (cur <= 2)
				{
					i++;
					if (i != j)
					{
						swap(a, i, j);
					}
				}
				j++;
			} else
			{
				i++;
				if (i != j)
				{
					swap(a, i, j);
				}
				j++;
				cur = 1;
			}
		}

		while ((n - 1) > i)
		{
			a.remove(--n);
		}

		return a.size();
	}

	private void swap(List<Integer> l, int i, int j)
	{
		int t = l.get(i);
		l.set(i, l.get(j));
		l.set(j, t);
	}

	public static void main(String[] args)
	{
		int r = new RemoveDuplicateII().removeDuplicates(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3)));
		System.out.println(r);
	}
}
