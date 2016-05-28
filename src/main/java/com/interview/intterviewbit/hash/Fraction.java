package com.interview.intterviewbit.hash;

import java.util.HashMap;
import java.util.Map;

public class Fraction
{
	public String findFraction(int n, int d){
		
		if(n==0 || d==0){
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		if((n<0) ^ (d<0)){
			sb.append("-");
		}
		
		long ln = n, ld =d;
		if(ln < 0){
			ln *= -1;
		}
		
		if(ld < 0){
			ld *= -1;
		}
		
		long temp = ln/ld;
		sb.append(String.valueOf(temp));
		
		if(ln%ld == 0){
			return sb.toString();
		}
		
		long rem = (ln%ld) * 10;
		StringBuilder sb2 = new StringBuilder();
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		sb.append(".");
		int count = 0;
		while(rem > 0){
			if(map.containsKey(rem)){
				String s = sb2.substring(0, map.get(rem));
				if(!s.isEmpty()){
					sb.append(s);
				}
				sb.append("(").append(sb2.substring(map.get(rem))).append(")");
				return sb.toString();
			}
			else{
				map.put(rem, count++);
				long t = rem/ld;
				sb2.append(String.valueOf(t));
			}
			
			rem %= ld;
			rem *=10;
		}
		
		sb.append(sb2);
		
		return sb.toString();
	}
	
	public static void main(String[] args){
//		String s = new Fraction().findFraction(Integer.MIN_VALUE, -1);
		String s = new Fraction().findFraction(87, 22);
		System.out.println(s);
		
//		int i = -1, j = -2;
//		if(i<0 ^ j<0){
//			System.out.println("yes!!!");
//		}
	}
}
