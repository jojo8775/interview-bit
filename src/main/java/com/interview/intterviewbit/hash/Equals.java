package com.interview.intterviewbit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equals
{
	public List<Integer> findIndex(List<Integer> nums){
		Map<Integer, Pair> map = new HashMap<Integer, Pair>();
		List<Integer> result = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE,Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		for(int i=0; i<nums.size(); i++){
			for(int j=i+1; j<nums.size(); j++){
				int sum = nums.get(i) + nums.get(j);
				
				if(map.containsKey(sum)){
					Pair p = map.get(sum);
					
//					if(p.index1 != i && p.index1 != j && p.index2 != i && p.index2 != j){
					if(p.index1 < i && p.index2 != i && p.index2 != j){
						List<Integer> tempResult = Arrays.asList(p.index1, p.index2, i, j);
						boolean replace = false;
						
						for(int k=0; k<4; k++){
							if(tempResult.get(k) < result.get(k)){
								replace = true;
								break;
							}
							else if(tempResult.get(k) > result.get(k)){
								replace = false;
								break;
							}
						}
						
						if(replace){
							result = tempResult;
						}
					}
				}
				else{
					map.put(sum, new Pair(i, j));
				}
			}
		}
		
		if(result.get(0) == Integer.MAX_VALUE){
			return new ArrayList<Integer>();
		}
		
		return result;
	}

	public List<Integer> find(List<Integer> nums)
	{
		Map<Integer, Pair> map = new HashMap<Integer, Pair>();
		int a1 = -1, b1 = -1, c1 = -1, d1 = -1;

		for (int i = 0; i < nums.size() - 1; i++)
		{
			for (int j = i + 1; j < nums.size(); j++)
			{
				int sum = nums.get(i) + nums.get(j);

				if (map.containsKey(sum))
				{
					Pair ps = map.get(sum);
					if (ps.index1 < ps.index2 && ps.index2 != i && ps.index2 != j && i < j)
					{
						if (a1 == -1)
						{
							a1 = ps.index1;
							b1 = ps.index2;
							c1 = i;
							d1 = j;
						} else if (ps.index1 < a1 || ps.index1 == a1 && ps.index2 < b1
								|| ps.index1 == a1 && ps.index2 == b1 && i < c1
								|| ps.index1 == a1 && ps.index2 == b1 && i == c1 && j < d1)
						{
							a1 = ps.index1;
							b1 = ps.index2;
							c1 = i;
							d1 = j;
						}
					}
				} else
				{
					Pair p = new Pair(i, j);

					if (!map.containsKey(sum))
					{
						map.put(sum, p);
					} else
					{
						Pair ps = map.get(sum);
						if (p.index1 <= ps.index1 && p.index2 <= ps.index2)
						{
							map.put(sum, p);
						}
					}
				}
			}
		}

		if (a1 == -1)
		{
			return new ArrayList<Integer>();
		}

		List<Integer> result = new ArrayList<Integer>();
		result.add(a1);
		result.add(b1);
		result.add(c1);
		result.add(d1);

		return result;
	}

	private static class Pair
	{
		int index1;
		int index2;

		public Pair(int index1, int index2)
		{
			this.index1 = index1;
			this.index2 = index2;
		}

		@Override
		public String toString()
		{
			return "Pair [index1=" + index1 + ", index2=" + index2 + "]";
		}
	}

	public static void main(String[] args)
	{
		// List<Integer> r = new Equals().find(Arrays.asList(1, 3, 3, 3, 3, 2,
		// 2));
		// List<Integer> r = new Equals().find(Arrays.asList(3, 4, 7, 1, 2, 9,
		// 8));
		List<Integer> r = new Equals().findIndex(Arrays.asList(0, 0, 1, 0, 2, 1));

		for (int i : r)
		{
			System.out.print(i + ", ");
		}
	}
}
