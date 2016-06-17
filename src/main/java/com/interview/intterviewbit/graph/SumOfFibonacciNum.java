package com.interview.intterviewbit.graph;

/**
 * How many minimum numbers from fibonacci series are required such that sum of
 * numbers should be equal to a given Number N? Note : repetition of number is
 * allowed.
 * 
 * Example:
 * 
 * N = 4 Fibonacci numbers : 1 1 2 3 5 .... so on here 2 + 2 = 4 so minimum
 * numbers will be 2
 * 
 * @author jojo
 *
 */
public class SumOfFibonacciNum
{
	public int fibsum(int a) {
	    if(a == 0){
	        return 0;
	    }
	    
	    int n1 = 1;
	    int n2 = 1;
	    
	    while(n2 <= a){
	        int temp = n2;
	        n2 += n1;
	        n1 = temp;
	    }
	    
	    return fibsum(a - n1) + 1;
	}
}
