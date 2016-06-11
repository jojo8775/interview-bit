package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * 
 * s = "myinterviewtrainer", dict = ["trainer", "my", "interview"]. Return 1 (
 * corresponding to true ) because "myinterviewtrainer" can be segmented as
 * "my interview trainer".
 * 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * @author jojo
 *
 */
public class WordBreak
{
	public int wordBreak(String a, ArrayList<String> b)
	{
		Set<String> dict = new HashSet<String>(b);
		int[] arr = new int[a.length() + 1];
		arr[0] = 1;

		for (int i = 0; i < a.length(); i++)
		{

			// check for the next begin index
			if (arr[i] != 1)
			{
				continue;
			}

			for (int j = i + 1; j <= a.length(); j++)
			{
				if (dict.contains(a.substring(i, j)))
				{
					arr[j] = 1;
				}
			}
		}

		return arr[a.length()];
	}
}
