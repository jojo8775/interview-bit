package com.interview.intterviewbit.dynamicprogram;
/**
 *Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

Example :

Given A = 3, there are a total of 5 unique BST’s.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * @author jojo
 */
public class UniqueBinarySearchTree
{
	public int numTrees(int a) {
	    if(a < 3){
	        return a;
	    }
	    else if(a == 0){
	        return 1;
	    }
	    
	    int[] grid = new int[a + 1];
	    grid[0] = 1;
	    grid[1] = 1;
	    grid[2] = 2;
	    
	    int sum = 0;
	    
	    for(int i=2; i<a; i++){
	        sum = 0;
	        for(int j=0; j<=i; j++){
	            sum += grid[j] * grid[i-j];
	        }
	        
	        grid[i+1] = sum;
	    }
	    
	    return grid[a];
	}
}
