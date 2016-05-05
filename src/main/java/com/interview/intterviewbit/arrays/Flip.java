package com.interview.intterviewbit.arrays;

import java.util.ArrayList;

public class Flip
{
	public ArrayList<Integer> sol(String s)
	{
		int max = 0, initialMax = 0;
		int maxIndex = 0;
		for (char ch : s.toCharArray())
		{
			if (ch == '1')
			{
				max++;
			}
		}
		
		initialMax = max;

		int currentMax = 1;

		if (s.charAt(0) == '0')
		{
			max++;
		}

		for (int i = 1; i < s.length(); i++)
		{
			int prevMax = currentMax;
			currentMax = s.charAt(i - 1) == '1' ? currentMax :  currentMax + 1;

			if (currentMax > prevMax && s.charAt(i) != '1')
			{
				max++;
				maxIndex = i;
			}
		}

		if(initialMax == max){
			return new ArrayList<Integer>();
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>(2);
		result.add(1);
		result.add(maxIndex+1);

		return result;
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> ll = new Flip().sol("111");

		if(ll.isEmpty()){
			System.out.println("No operation required");
		}
		else{
			System.out.println(ll.get(0) + ", " + ll.get(1));
		}
	}
}
