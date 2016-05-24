package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneratePerenthesis
{
	public List<String> generate(int n){
		List<String> result = new ArrayList<String>();
		generate(n, n, new char[n*2], 0, result);
		return result;
	}
	
	private void generate(int ob, int cb, char[] s, int idx, List<String> result){
		if(ob > cb){
			return;
		}
		
		if(ob == 0 && cb == 0){
			result.add(String.valueOf(s));
			return ;
		}
		
		if(ob > 0){
			s[idx] = '(';
			generate(ob - 1, cb, s, idx+1, result);
		}
		
		if(cb > 0){
			s[idx] = ')';
			generate(ob, cb - 1, s, idx+1, result);
		}
	}
	
	public static void main(String[] args){
		List<String> ss = new GeneratePerenthesis().generate(3);
		
		for(String s : ss){
			System.out.println(s);
		}
	}
}
