package com.interview.intterviewbit.recursion;

public class Permutation
{
	private String result = null;
	private int k = 0;
	
	public String sol(int n, int k){
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<= n; i ++){
			sb.append(i);
		}
		
		this.k = k;
		
		p("", sb.toString());
		
		return result;
	}

	public void p(String sofar, String rem){
		if(k < 1){
			return;
		}
		if(rem.isEmpty()){
			result = sofar;
			k --;
			return;
		}
		
		for(int i=0; i<rem.length(); i++){
			p(sofar + rem.charAt(i), rem.substring(0,i)+ rem.substring(i+1));
		}
	}
	
	
	public void permute(String sofar, String rem){
		if(rem.isEmpty()){
			System.out.println(sofar);
			return;
		}
		
		for(int i=0; i<rem.length(); i++){
			permute(sofar + rem.charAt(i), rem.substring(0,i)+ rem.substring(i+1));
		}
	}
	
	public static void main(String[] args){
//		new Permutation().permute("", "123");
		String s = new Permutation().sol(3, 3);
		System.out.println(s);
	}
}
