package com.interview.intterviewbit.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NthSmallestElement
{
	public List<Integer> updatedArray(List<Integer> nums){
		List<Integer> result = new ArrayList<Integer>();
		
		int idx = 0, n = nums.size();
		Stack<Integer> stack = new Stack<Integer>();
		
		while(idx < n){
			if(stack.isEmpty()){
				result.add(-1);
				stack.push(nums.get(idx++));
			}
			else if(stack.peek() < nums.get(idx)){
				result.add(nums.get(idx));
				stack.push(nums.get(idx++));
			}
			else{
				stack.pop();
			}
		}
		
		return result;
	}
}