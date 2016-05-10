package com.interview.intterviewbit.math;

import java.util.ArrayList;
import java.util.List;

public class SquareSum
{
	public List<ArrayList<Integer>> squareSum(int A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int a = 1; a <=Math.sqrt(a); a++) {
			for (int b = 1; b * b <= A-a && b<=a; b++) {
				if (a * a + b * b == A) {
					ArrayList<Integer> newEntry = new ArrayList<Integer>();
					newEntry.add(a);
					newEntry.add(b);
					ans.add(newEntry);
				}
			}
		}
		return ans;
	}
	
//	public List<ArrayList<Integer>> squareSum(int A) {
//		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
//
//		for (int a = 1; a * a <= A; a++) {
//			for (int b = 1; b * b <= A-a && b<=a; b++) {
//				if (a * a + b * b == A) {
//					ArrayList<Integer> newEntry = new ArrayList<Integer>();
//					newEntry.add(a);
//					newEntry.add(b);
//					ans.add(newEntry);
//				}
//			}
//		}
//		return ans;
//	}
}
