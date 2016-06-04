package com.interview.intterviewbit.dynamicprogram;

/**
 * mplement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * 
 * int isMatch(const char *s, const char *p) Some examples:
 * 
 * isMatch("aa","a") → 0 isMatch("aa","aa") → 1 isMatch("aaa","aa") → 0
 * isMatch("aa", "a*") → 1 isMatch("aa", ".*") → 1 isMatch("ab", ".*") → 1
 * isMatch("aab", "c*a*b") → 1 Return 0 / 1 ( 0 for false, 1 for true ) for this
 * problem
 * 
 * @author jojo
 *
 */
public class RegularExpressionII
{
	public boolean isMatch(String s, String p)
	{
		if (p.length() == 0)
			return s.length() == 0;

		// p's length 1 is special case
		if (p.length() == 1 || p.charAt(1) != '*')
		{
			if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch(s.substring(1), p.substring(1));

		}
		else
		{
			// taking negative to cover case when s is empty
			int i = -1;
			while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i)))
			{
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}

	public static void main(String[] args)
	{
		// int r = new RegularExpression().isMatch("ab*c", "abc");
		// int r = new RegularExpression().isMatch("a", ".");
		// int r = new RegularExpression().isMatch("a.*", "ac");
		boolean r = new RegularExpressionII().isMatch("ac", "ab*c");
		System.out.println(r);
	}
}
