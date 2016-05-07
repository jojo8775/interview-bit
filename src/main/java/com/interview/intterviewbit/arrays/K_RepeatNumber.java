package com.interview.intterviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class K_RepeatNumber
{
	public int repeatedNumber(final List<Integer> a)
	{
		int r = repeatedNumbers(a, 3);
		System.out.println(r);
		return r;
	}

	private int repeatedNumbers(List<Integer> n, int k)
	{
		Element[] element = new Element[k];

		for (int i = 0; i < k; i++)
		{
			element[i] = new Element();
		}

		for (int i = 0; i < n.size(); i++)
		{
			int num = n.get(i);

			boolean found = false;

			for (int j = 0; j < k; j++)
			{
				if (element[j].val == num)
				{
					element[j].count += 1;
					found = true;
					break;
				}
			}

			boolean added = false;

			if (!found)
			{
				for (int j = 0; j < k; j++)
				{
					if (element[j].count == 0)
					{
						element[j].count += 1;
						element[j].val = num;
						added = true;
						break;
					}
				}
			}

			if (!found && !added)
			{
				for (int j = 0; j < k; j++)
				{
					element[j].count -= 1;
					if(element[j].count == 0){
						element[j].val = 0;
					}
				}
			}
		}
		
		for(int i=0; i<k; i++){
			int count = 0;
			for(int j=0; j<n.size(); j++){
				if(element[i].val == n.get(j)){
					count ++;
				}
			}
			
			if(count > n.size()/k){
				return element[i].val;
			}
		}
		
		return -1;
	}

	public static void main(String[] args){
//		new K_RepeatNumber().repeatedNumber(Arrays.asList(1,2,3,1,1));
		new K_RepeatNumber().repeatedNumber(Arrays.asList(1, 1, 1, 2, 3, 5, 7));
	}
	
	private static class Element
	{
		int val;
		int count;
		@Override
		public String toString()
		{
			return "Element [val=" + val + ", count=" + count + "]";
		}
	}
}
