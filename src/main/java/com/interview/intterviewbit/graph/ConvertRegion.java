package com.interview.intterviewbit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertRegion
{
	private Queue<Integer> queue = new LinkedList<Integer>();

	public void solve(List<List<Character>> a)
	{
		if (a == null || a.size() == 1 || a.get(0).size() == 1)
		{
			return;
		}

		// merging all boarder 'O's
		for (int i = 0; i < a.size(); i++)
		{
			if(a.get(i).get(0) == 'O'){
				mergeCell(a, i, 0);
			}
		}
		
		for (int i = 0; i < a.get(0).size(); i++)
		{
			if(a.get(0).get(i) == 'O'){
				mergeCell(a, 0, i);
			}
		}
		

		// scanning and converting
		for (int i = 0; i < a.size(); i++)
		{
			for (int j = 0; j < a.get(i).size(); j++)
			{
				if (a.get(i).get(j) == 'O')
				{
					a.get(i).set(j, 'X');
				} else if (a.get(i).get(j) == '#')
				{
					a.get(i).set(j, 'O');
				}
			}
		}
	}

	private void mergeCell(List<List<Character>> a, int i, int j)
	{
		int len = a.get(i).size();
		queue.add(i * len + j);

		while (!queue.isEmpty())
		{
			int pi = queue.peek() / len;
			int pj = queue.poll() % len;

			a.get(pi).set(pj, '#');

			// top
			if (pi - 1 >= 0 && a.get(pi - 1).get(pj) == 'O')
			{
				queue.add((pi - 1) * len + pj);
			}

			// bottom
			if (pi + 1 < a.size() && a.get(pi + 1).get(pj) == 'O')
			{
				queue.add((pi + 1) * len + pj);
			}

			int width = a.get(i).size();
			// left
			if (pj - 1 >= 0 && a.get(pi).get(pj - 1) == 'O')
			{
				queue.add(pi * len + pj - 1);
			}

			// right
			if (pj + 1 < width && a.get(pi).get(pj + 1) == 'O')
			{
				queue.add(pi * len + pj + 1);
			}
		}
	}

	public static void main(String[] args)
	{
//		List<List<Character>> grid = Arrays.asList(Arrays.asList('X', 'X', 'X'), Arrays.asList('X', 'O', 'X'),
//				Arrays.asList('X', 'X', 'X'));
		
		List<List<Character>> grid = 
				Arrays.asList(
						Arrays.asList('O','O','O','X','X','O','X','O'), 
						Arrays.asList('X','X','X','X','O','X','O','O'));
		
		new ConvertRegion().solve(grid);
		System.out.println("end");
	}
}
