package com.interview.intterviewbit.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeSum
{
	private List<Integer> findPrimes(int a){
		List<Integer> primes = new ArrayList<Integer>();
		for(int i=1; i<= a; i++){
			if(isPrime(i)){
				primes.add(i);
			}
		}
		
		int start=0, end=primes.size()-1;
		
		while(start < end){
			int n1 = primes.get(start);
			int n2 = primes.get(end);
			
			if(n1 + n2 == a){
				List<Integer> result = new ArrayList<Integer>();
				result.add(n1);
				result.add(n2);
				return result;
			}
			else if (n1 + n2 < a){
				start ++;
			}
			else {
				end --;
			}
		}
		
		return new ArrayList<Integer>();
	}
	
	private boolean isPrime(int a){
		for(int i=2; i<=Math.sqrt(a); i++){
			if(a%i==0){
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args){
		new PrimeSum().findPrimes(4);
	}
}
	