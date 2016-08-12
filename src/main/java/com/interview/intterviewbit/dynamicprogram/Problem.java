package com.interview.intterviewbit.dynamicprogram;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an input array with a million integers, write a function (in any
 * language of your choice) which returns True if the input integer array
 * contains any two elements summing to 42. Return False otherwise.
 */
public class Problem {
	private static final int TARGET = 42;

	public boolean findNumber(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : arr) {
			int numToLook = TARGET - i;

			// checking if pair exist.
			if (set.contains(numToLook)) {
				return true;
			}

			set.add(i);
		}

		// could not find a pair
		return false;
	}

	// Helper function to run test case. 
	public static void main(String[] args) {
		Problem prob = new Problem();

		// Testing use case when negative number is required to make 42
		System.out.println(prob.findNumber(new int[] { 46, -4 }));

		// Testing use case when positive number is required to make 42
		System.out.println(prob.findNumber(new int[] { -4, 46 }));

		// Testing integer overflow when INT_MAX and INT_MIN value is present
		System.out.println(prob.findNumber(new int[] { -4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE,
				Integer.MIN_VALUE, Integer.MIN_VALUE, 46 }));
		
		// Testing use case when target cannot be found;
		System.out.println(prob.findNumber(new int[] { -4}));
	}
}
