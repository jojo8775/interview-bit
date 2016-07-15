package com.interview.intterviewbit.math;

/**
 * 9, 6
 * 
 * 6%9=6, 9
 * 
 * 9%6=3, 6
 * 
 * 6%3=0, 3 --- 3 is the result!
 * 
 * @author jojo
 *
 */
public class GCD {
	public int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}

		return gcd(b % a, a);
	}

	public static void main(String[] args) {
		int r = new GCD().gcd(52, 704);
		System.out.println(r);
	}
}
