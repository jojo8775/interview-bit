package com.interview.intterviewbit.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * You are given an integer N. You have to find smallest multiple of N which
 * consists of digits 0 and 1 only. Since this multiple could be large, return
 * it in form of a string.
 * 
 * Note: - Returned string should not contain leading zeroes.
 * 
 * For example,
 * 
 * For N = 55, 110 is smallest multiple consisting of digits 0 and 1. For N = 2,
 * 10 is the answer.
 * 
 * @author jojo
 *
 */
public class SmallestMultiple
{
	public String getNumber(int num)
	{
		if (num == 0)
		{
			return "0";
		}

		Map<Integer, Integer> valueByNode = new HashMap<Integer, Integer>();
		Map<Integer, Integer> parentByChild = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();

		// adding the root element
		queue.add(1 % num);
		valueByNode.put(1 % num, 1);

		while (queue.peek() != 0)
		{
			int mod = queue.poll();
			int child = (mod * 10) % num;

			if (!valueByNode.containsKey(child))
			{
				valueByNode.put(child, 0);
				parentByChild.put(child, mod);
				queue.add(child);
			}

			child++;

			if (child == num)
			{
				child = 0;
			}

			if (!valueByNode.containsKey(child))
			{
				valueByNode.put(child, 1);
				parentByChild.put(child, mod);
				queue.add(child);
			}
		}

		int node = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(valueByNode.get(0));

		while (parentByChild.get(node) != null)
		{
			node = parentByChild.get(node);
			sb.append(valueByNode.get(node));
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args)
	{
		String r = new SmallestMultiple().getNumber(3);
		System.out.println(r);
	}
}
