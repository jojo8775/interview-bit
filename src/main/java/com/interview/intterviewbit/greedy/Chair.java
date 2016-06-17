package com.interview.intterviewbit.greedy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 
 * There is a row of seats. Assume that it contains N seats adjacent to each
 * other. There is a group of people who are already seated in that row
 * randomly. i.e. some are sitting together & some are scattered.
 * 
 * An occupied seat is marked with a character 'x' and an unoccupied seat is
 * marked with a dot ('.')
 * 
 * Now your target is to make the whole group sit together i.e. next to each
 * other, without having any vacant seat between them in such a way that the
 * total number of hops or jumps to move them should be minimum.
 * 
 * Return minimum value % MOD where MOD = 10000003
 * 
 * @author jojo
 *
 */
public class Chair
{
	private static int MOD = 10000003;

	public int seats(String a)
	{
		LinkedList<int[]> pq = new LinkedList<int[]>();

		int j = 0;
		for (int i = 0; i < a.length(); i++)
		{
			if (a.charAt(i) == '.')
			{
				continue;
			}

			for (j = i + 1; j < a.length(); j++)
			{
				if (a.charAt(j) == '.')
				{
					break;
				}
			}

			pq.add(new int[] { i, j - 1 });

			i = j;
		}

		int moves = 0;

		while (pq.peekFirst() != pq.peekLast())
		{
			int leftLen = pq.peekFirst()[1] - pq.peekFirst()[0] + 1;
			int rightLen = pq.peekLast()[1] - pq.peekLast()[0] + 1;

			// merge right to left
			if (leftLen > rightLen)
			{
				int[] temp = pq.pollLast();
				moves += rightLen * (temp[0] - pq.peekLast()[1] - 1);
				pq.peekLast()[1] += rightLen;
			}
			// merge left to right
			else
			{
				int[] temp = pq.pollFirst();
				moves += leftLen * (pq.peekFirst()[0] - temp[1] - 1);
				pq.peekFirst()[0] -= leftLen;
			}

			moves %= MOD;
		}

		return moves;
	}

	public static void main(String[] args)
	{
		// int moves = new Chair().seats("....x..xx...x..");
		int moves = new Chair().seats(".x.x.x..x");
		System.out.println(moves);
	}
}
