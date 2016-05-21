package com.interview.intterviewbit.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaxAreaHistogram
{
	public int largestRectangleArea(List<Integer> a) {
	    int maxArea=a.get(0),tempArea=0;
	    
	    Stack<Integer> stack = new Stack<Integer>();
	    
	    for(int i=0;i<a.size();i++){
	    	if(stack.isEmpty() || a.get(stack.peek()) <= a.get(i)){
	    		stack.push(i);
	    	}
	    	else{
	    		while(!stack.isEmpty() && a.get(stack.peek()) > a.get(i)){
	    			int storedIndex = stack.pop();
	    			tempArea = a.get(storedIndex) * (i-storedIndex - 1);
	    			if(tempArea > maxArea){
	    				maxArea = tempArea;
	    			}
	    		}
	    		stack.push(i);
	    	}
	    }
	    
	    int idx = a.size();
	    while(!stack.isEmpty()){
	    	int storedIndex = stack.pop();
			tempArea = a.get(storedIndex) * (idx-storedIndex - 1);
			if(tempArea > maxArea){
				maxArea = tempArea;
			}
	    }
	    
	    return maxArea;
	}
	
	public int maxHistogram(List<Integer> input){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.size();){
            if(stack.isEmpty() || input.get(stack.peekFirst()) <= input.get(i)){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input.get(top) * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input.get(top) * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input.get(top) * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input.get(top) * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args){
		int r = new MaxAreaHistogram().maxHistogram(Arrays.asList( 90, 58, 69, 70, 82, 100, 13, 57, 47, 18 ));
//		int r = new MaxAreaHistogram().maxHistogram(Arrays.asList( 2,1,5,6,2,3 ));
		System.out.println(r);
	}
}
