package com.interview.intterviewbit.arrays;

import java.util.List;

public class SetMatrixZero
{
	public void setZero(List<List<Integer>> arr){
		boolean firstRowContainsZero = false, firstColContainsZero = false;
		
		for(int i=0; i<arr.get(0).size(); i++){
			if(arr.get(0).get(i) == 0){
				firstRowContainsZero = true;
				break;
			}
		}
		
		for(int i=0; i<arr.size(); i++){
			if(arr.get(i).get(0) == 0){
				firstColContainsZero = true;
				break;
			}
		}
	
		for(int i=1; i<arr.size(); i++){
			for(int j=1; j<arr.get(0).size(); j++){
				if(arr.get(i).get(j) == 0){
					arr.get(0).set(j,0);
					arr.get(i).set(0,0);
				}
			}
		}
		
		for(int i=0; i<arr.size(); i++){
			if(arr.get(0).get(i) == 0){
				for(int j=1; j<arr.size(); j++){
					arr.get(j).set(i, 0);
				}
			}
			if(firstRowContainsZero){
				arr.get(0).set(i, 0);
			}
		}
		
		for(int i=0; i<arr.get(0).size(); i++){
			if(arr.get(0).get(i) == 0){
				for(int j=1; j<arr.size(); j++){
					arr.get(j).set(i, 0);
				}
			}
			if(firstRowContainsZero){
				arr.get(0).set(i, 0);
			}
		}
	}
}	