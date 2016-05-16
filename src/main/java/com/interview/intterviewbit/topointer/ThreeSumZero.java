package com.interview.intterviewbit.topointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumZero
{
	public List<List<Integer>> findSum(List<Integer> list)
	{
		if(list.size() < 3){
			return Collections.emptyList();
		}
		
		Collections.sort(list);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < list.size(); i++)
		{
			int k = list.size() - 1;
			int j = i + 1;
			while (j < k)
			{
				int sum = list.get(i) + list.get(j) + list.get(k);
				if (sum == 0)
				{
					result.add(Arrays.asList(list.get(i), list.get(j), list.get(k)));
					k = findLowerBound(list, k) - 1;
					j = findUpperBound(list, j) + 1;
				} else if (sum < 0)
				{
					j = findUpperBound(list, j) + 1;
				} else
				{
					k = findLowerBound(list, k) - 1;
				}
			}
			
			i = findUpperBound(list, i);
		}

		return result;
	}

	private int findLowerBound(List<Integer> list, int index)
	{
		while (index - 1 >= 0 && list.get(index).equals(list.get(index - 1)))
		{
			index--;
		}

		return index;
	}

	private int findUpperBound(List<Integer> list, int index)
	{
		while (index + 1 < list.size() && list.get(index).equals(list.get(index + 1)))
		{
			index++;
		}

		return index;
	}

	public static void main(String[] args)
	{
//		List<List<Integer>> result = new ThreeSumZero().findSum(Arrays.asList(-1, 0, 1, 2, -1, -4));
//		List<List<Integer>> result = new ThreeSumZero().findSum(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3));
		List<List<Integer>> result = new ThreeSumZero().findSum(Arrays.asList(-31013930, -31013930, 9784175, 21229755));
		
		for(List<Integer> ll : result){
			for(int i : ll){
				System.out.print(i + ", ");
			}
			
			System.out.println();
		}
	}
}
