package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonal
{
public ArrayList<ArrayList<Integer>> diagonal(List<List<Integer>> a) {
	    
	    ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
	    for(int k=0; k<a.size(); k++){
	        int j=k;
	        int i= 0;
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        while(i<a.size() && j>=0){
	            result.add(a.get(i).get(j));
	            i++;
	            j--;
	        }
	        
	        resultList.add(result);
	    }
	    
	    int i = 1;
	    while(i < a.size()){
	        int j=a.size() - 1;
	        int k=i;
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        while(k<a.size() && j>=0){
	            result.add(a.get(k).get(j));
	            k++;
	            j--;
	        }
	        
	        resultList.add(result);
	        
	        i++;
	    }
	    
	    return resultList;
	}

	public static void main(String[] args){
		
		List<Integer> i1 = Arrays.asList(1,2);
		List<Integer> i2 = Arrays.asList(3,4);
		
		new AntiDiagonal().diagonal(Arrays.asList(i1,i2));
	}
}
