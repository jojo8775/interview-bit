package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> result = new ArrayList<String>();
		dfs(result, new StringBuilder(), s, 0, wordDict);
		return result;
	}
	
	private void dfs(List<String> result, StringBuilder sb, String str, int idx, Set<String> wordDict){
		if(wordDict.contains(sb.toString())){
			
		}
	}

	public static void main(String[] args) {
		List<String> result = new WordBreakII().wordBreak("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aaa")));
		for (String s : result) {
			System.out.println(s);
		}
	}
}
