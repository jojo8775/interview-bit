package com.interview.intterviewbit.topointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicate
{
	public int removeDuplicate(List<Integer> list)
	{
		int i = 0, j = i + 1, n = list.size();

		while (j < n)
		{
			if (list.get(i).equals(list.get(j)))
			{
				j++;
			} 
			else
			{
				i++;
				if(i != j){
					swap(list, i, j);
				}
				j++;
			}
		}

		while (n - 1 > i)
		{
			list.remove(--n);
		}

		return list.size();
	}

	private void swap(List<Integer> list, int i, int j)
	{
		int t = list.get(i);
		list.set(i, list.get(j));
		list.set(j, t);
	}

	public static void main(String[] args)
	{
		int r = new RemoveDuplicate().removeDuplicate(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3)));
		System.out.println(r);
	}
}
