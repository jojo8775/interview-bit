package com.interview.intterviewbit.dynamicprogram;

import java.util.Stack;

public class LongestValidParenthesis{
	
	public int longestValidParenthesis(String s){
		Stack<int[]> stack = new Stack<int[]>();
		
		int maxLength = 0;
		
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '('){
				int [] t = {i,0};
				stack.push(t);
			}
			else{
				if(stack.isEmpty() || stack.peek()[1] == 1){
					int[] t = {i,1};
					stack.push(t);
				}
				else{
					stack.pop();
					if(stack.isEmpty()){
						maxLength = Math.max(i + 1, maxLength);
					}
					else{
						maxLength = Math.max(maxLength, i - stack.peek()[0]);
					}
				}
			}
		}
		
		return maxLength;
	}
	
	public static void main(String[] args){
		int r = new LongestValidParenthesis().longestValidParenthesis(")()())");
		System.out.println(r);
	}
}
