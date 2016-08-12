package com.interview.intterviewbit.dynamicprogram;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an input array with a million integers, write a function (in any
 * language of your choice) which returns True if the input integer array
 * contains any two elements summing to 42. Return False otherwise.
 */
public class Problem {
	public boolean findNumber(int[] arr, int target) {
		// base case
		if (arr == null || arr.length < 2) {
			return false;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i : arr) {
			int numToLook = 0;
			if (i <= target) {
				numToLook = target - i;
			} else {
				numToLook = i - target;
			}

			// checking if pair exist.
			if (set.contains(numToLook)) {
				return true;
			}

			set.add(i);
		}

		// could not find a pair
		return false;
	}

	public static void main(String[] args) {
		Problem prob = new Problem();

		// testing number found
		System.out.println(prob.findNumber(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 42, -1, 0, 1 }, 42));

		// testing MAX_VAL lookup
		System.out.println(
				prob.findNumber(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 42, -1, 0, 1 }, Integer.MIN_VALUE));

		// testing MIN_VAL lookup
		System.out.println(
				prob.findNumber(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 42, -1, 0, 1 }, Integer.MIN_VALUE));

		// testing number not found
		System.out.println(prob.findNumber(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 42, -1, 0, 1 }, 45));
		
		// testing null input
		System.out.println(prob.findNumber(null, 45));
	}
}
