package com.interview.intterviewbit.dynamicprogram;

/**
 * implement regular expression matching with support for '.' and '*'.
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
		System.out.println("S: " + s + " P: " + p);
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
	
	public boolean solDP(String s, String p){
		
		boolean[][] grid = new boolean[s.length() + 1][p.length() + 1];
		grid[0][0] = true;
		
		//zeroth row 
		for(int i=1; i<grid[0].length; i++){
			if(p.charAt(i-1) == '*'){
				grid[0][i] = grid[0][i-2];
				grid[0][i-1] = grid[0][i-2];
			}
			else if(p.charAt(i-1) == ' '){
				grid[0][i] = grid[0][i-1];
			}
		}
		
		//zeroth col 
		for(int i=1; i<grid.length; i++){
			if(s.charAt(i-1) == '*'){
				grid[i][0] = grid[i-2][0];
				grid[i-1][0] = grid[i-2][0];
			}
			else if(s.charAt(i-1) == ' '){
				grid[i][0] = grid[i-1][0];
			}
		}
		
		for(int i=1; i<=p.length(); i++){
			char ch = p.charAt(i-1);
			// when ch == '*'
			if(ch == '*'){
				// copy data assuming * represents empty seq
				for(int j=1; j<grid.length; j++){
					grid[j][i] = grid[j][i-2];
				}
				
				// if * contributes to matching 
				for(int j=1; j<grid.length; j++){
					if(p.charAt(i-2) == '.' || s.charAt(j-1) == p.charAt(i-2)){
						grid[j][i] = grid[j][i] || grid[j-1][i-2] || grid[j-1][i];
					}
				}
			}
			
			// when ch == '.'
			else if(ch == '.'){
				for(int j=1; j<=s.length(); j++){
					grid[j][i] = grid[j-1][i-1];
				}
			}
			
			else{
				for(int j=1; j<=s.length(); j++){
					if(s.charAt(j-1) == ch){
						grid[j][i] = grid[j-1][i-1]; 
					}
				}
			}
		}
		
		print(grid);
		
		return grid[s.length()][p.length()];
	}
	
	private static void print(boolean[][] B){
		for(int i=0; i<B.length; i++){
			for(int j=0; j<B[0].length; j++){
				System.out.print((B[i][j] ? "T" : "F") + ", ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		// int r = new RegularExpression().isMatch("ab*c", "abc");
		// int r = new RegularExpression().isMatch("a", ".");
		// int r = new RegularExpression().isMatch("a.*", "ac");
		boolean r = new RegularExpressionII().isMatch("abbbc", "ab*d*c");
		System.out.println(r);
	}
}
