package com.interview.intterviewbit.string;

public class PowerOf2
{
	public int power(String a){
		char[] arr = a.toCharArray();
		
		int n = arr.length - 1;
		boolean isDivisible = arr[n] % 2 == 0;
		
		int beg = 0, cur = 0, rem = 0;
		
		while(isDivisible){
			while(beg <= n){
				cur = arr[beg] - '0' + rem;
				if(cur < 2){
					rem = cur * 10;
					arr[beg] = '0';
				}
				else{
					rem = cur%2 * 10;
					arr[beg] = (char) ((cur/2) + '0');
				}
				beg ++;
			}
			
			int start = 0;
			while(start < beg && arr[start] == '0'){
				start++;
			}
			
			beg = start;
			
			System.out.println(String.valueOf(arr));
			
			if(beg - n == 0 && arr[beg] == '1'){
				return 1;
			}
			else{
				isDivisible = arr[n]%2 == 0;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args){
		System.out.println(new PowerOf2().power("256"));
	}
}
