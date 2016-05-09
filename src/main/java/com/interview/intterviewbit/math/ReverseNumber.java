package com.interview.intterviewbit.math;

public class ReverseNumber
{
	public int reverse(int a){
		String s = String.valueOf(a);
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(s.charAt(count) == '-'){
			sb.append(s.charAt(count++));
		}
		
		int max = s.length() - 1;
		while(max>=count){
			if(s.charAt(max) != '0'){
				break;
			}
			max --;
		}
		
		for(int i = max; i>=count; i--){
			sb.append(s.charAt(i));
		}
		
		long val = Long.valueOf(sb.toString());
		if(val > Integer.MAX_VALUE || val < Integer.MIN_VALUE){
			return 0;
		}
		
		return (int) val;
	}
	
	public static void main(String[] args){
		int r = new ReverseNumber().reverse(-320);
		System.out.println(r);
	}
}
