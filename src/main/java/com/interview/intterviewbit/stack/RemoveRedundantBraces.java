package com.interview.intterviewbit.stack;

import java.util.Stack;

public class RemoveRedundantBraces
{
	public int hasRedundantBrances(String s){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == ')'){
				int count = 0;
				while(!stack.isEmpty() && !stack.peek().equals('(')){
					stack.pop();
					count ++;
				}
				stack.pop();
				if(count < 2){
					return 1;
				}
			}
			else{
				stack.push(s.charAt(i));
			}
		}
		
		boolean redundant = false;
		
		while(!stack.isEmpty()){
			if(stack.peek().equals('(') || stack.peek().equals(')')){
				redundant = true;
				break;
			}
			
			stack.pop();
		}
		
		return redundant ? 1 : 0;
	}
	
	public static void main(String[] args){
		int r = new RemoveRedundantBraces().hasRedundantBrances("(( a + (b + c)))");
		System.out.println(r);
	}
}
