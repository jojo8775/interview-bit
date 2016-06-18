package com.interview.intterviewbit.graph;

import java.util.ArrayList;
import java.util.Collections;

/*-
 * Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12 
Return the numbers in sorted order.
 */
public class SteppingNumber
{
private ArrayList<Integer> result = new ArrayList<Integer>();
    
	public ArrayList<Integer> stepnum(int a, int b) {
	    if(a == 0){
	        result.add(a);
	    }
	    
        for(int i=1; i<10; i++){
			dfs(a, b, i);
		}
		Collections.sort(result);

		return result;
	}

	private void dfs(int a, int b, int num)
	{
		if (num > b)
		{
			return;
		}

		if (num >= a)
		{
			result.add(num);
		}
		
		int temp = num * 10;
		int mod = num % 10;
		if (mod == 0)
		{
		    dfs(a, b, temp + ((temp/10)%10) + 1);
		} 
		else if (mod == 9)
		{
			dfs(a, b, temp + mod - 1);
		} else
		{
			dfs(a, b, temp + mod + 1);
			dfs(a, b, temp + mod - 1);
		}
	}
}
