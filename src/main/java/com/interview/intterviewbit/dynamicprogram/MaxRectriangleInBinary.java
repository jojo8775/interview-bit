package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

 * @author jojo
 *
 */
public class MaxRectriangleInBinary
{
	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
	    int[] dp = new int[a.get(0).size()];
	    
	    int maxArea = 0;
	    
	    for(int i=0; i<a.size(); i++){
	        for(int j=0; j<a.get(0).size(); j++){
	            if(a.get(i).get(j) == 0){
	                dp[j] = 0;
	            }
	            else{
	                dp[j] += a.get(i).get(j); 
	            }
	        }
	        
	        maxArea = Math.max(maxArea, findArea(dp));
	    }
	    
	    return maxArea;
	}
	
	private int findArea(int[] dp){
	    int maxArea = dp[0], tempArea = maxArea, n = dp.length;
	    
	    Stack<Integer> stack= new Stack<Integer>();
	    
	    int i = 0;
	    while(i< n){
	        if(stack.isEmpty() || dp[stack.peek()] <= dp[i]){
	            stack.push(i++);
	        }
	        else{
                int top = stack.pop();
                
                if(stack.isEmpty()){
                    tempArea = dp[top] * top;
                }
                else{
                    tempArea = dp[top] * (i - stack.peek() - 1);
                }
	                
                maxArea = Math.max(tempArea, maxArea);
	        }
	    }
	    
	    while(!stack.isEmpty()){
	        int top = stack.pop();
	        
	        if(stack.isEmpty()){
	            tempArea = dp[top] * n;
	        }
	        else{
	            tempArea = dp[top] * (n - stack.peek() - 1);
	        }
	        
	        maxArea = Math.max(tempArea, maxArea);
	    }
	    
	    return maxArea;
	}
	
	public int maxHistogram(int input[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
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
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args){
		int[] dp = {2,1,3,1};
		int i = new MaxRectriangleInBinary().findArea(dp);
		
		System.out.println(i);
	}
}
