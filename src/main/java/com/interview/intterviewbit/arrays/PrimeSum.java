package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrimeSum
{
	public List<Integer> findPrime(int a ){
		for(int i=2; i<=a/2; i++){
			if(isPrime(i) && isPrime(a-i)){
				List<Integer> result = new ArrayList<Integer>();
				result.add(i);
				result.add(a-i);
				
				return result;
			}
		}
		
		return new ArrayList<Integer>();
	}
	
	private boolean isPrime(int a){
		for(int i=2; i<=Math.sqrt(a); i++){
			if(a%i == 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		List<Integer> r = new PrimeSum().findPrime(4);
		System.out.println(r.size());
	}
}
