package com.interview.intterviewbit.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression
{
	public int evaluate(List<String> a){
		if(a.size() < 2){
			return Integer.valueOf(a.get(0));
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int result = 0, num1=0, num2=0;
		for(int i=0; i<a.size(); i++){
			switch (a.get(i))
			{
			case "*": 
				num2 = stack.pop();
				num1 = stack.pop();
				result =  num1 * num2;
				stack.push(result);
				break;
			case "+": 
				num2 = stack.pop();
				num1 = stack.pop();
				result =  num1 + num2;
				stack.push(result);
				break;
			case "-": 
				num2 = stack.pop();
				num1 = stack.pop();
				result =  num1 - num2;
				stack.push(result);
				break;
				
			case "/": 
				num2 = stack.pop();
				num1 = stack.pop();
				result =  num1 / num2;
				stack.push(result);
				break;

			default:
				stack.push(Integer.valueOf(a.get(i)));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
//		int result = new EvaluateExpression().evaluate(Arrays.asList("2", "1", "+", "3", "*"));
		int result = new EvaluateExpression().evaluate(Arrays.asList("4", "13", "5", "/", "+"));
		
		System.out.println(result);
	}
}
