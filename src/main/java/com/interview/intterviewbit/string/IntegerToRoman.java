package com.interview.intterviewbit.string;

/**
 * Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"
 * @author jojo
 *
 */
public class IntegerToRoman
{
	public String convertToRoman(int num){
		int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		StringBuilder sb = new StringBuilder();
		while(num>0){
			int i = 0;
			for(; i<nums.length; i++){
				if(num >= nums[i]){
					break;
				}
			}
			int count = num / nums[i];
			while(count>0){
				sb.append(symbol[i]);
				count--;
			}
			num = num % nums[i];
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args){
//		System.out.println(new IntegerToRoman().convertToRoman(3));
		System.out.println(new IntegerToRoman().convertToRoman(1));
	}
}

