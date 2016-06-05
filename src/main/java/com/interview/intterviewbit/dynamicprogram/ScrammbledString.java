package com.interview.intterviewbit.dynamicprogram;
/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
 
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. Return 0/1 for this problem.
 * @author jojo
 *
 */
public class ScrammbledString
{
	public int isScramble(final String a, final String b) {
	    // check if the strings are equal
	    if(a.equals(b)){
	        return 1;
	    }
	    
	    // check if string characters are equal
	    int[] index = new int[256];
	    for(int i=0; i<a.length(); i++){
	        index[a.charAt(i)]++;
	        index[b.charAt(i)]--;
	    }
	    
	    for(int i=0; i<index.length; i++){
	        if(index[i] != 0){
	            return 0;
	        }
	    }
	    
        // recursive split of string to left and right sub tree
        for(int i=1; i<a.length(); i++){
            if(isScramble(a.substring(0, i), b.substring(0,i)) == 1 
                && isScramble(a.substring(i), b.substring(i)) == 1){
                return 1;
            }
            
            if(isScramble(a.substring(0, i), b.substring(b.length() - i)) == 1 
                && isScramble(a.substring(i), b.substring(0,b.length() - i)) == 1){
                return 1;
            }
        }
        
        return 0;
	}
}
