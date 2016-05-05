package com.interview.intterviewbit.arrays;

import java.util.ArrayList;

public class MinimumSetpsInInfiniteGrid
{
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int totalMoves = 0;
        
        for(int i=1; i< X.size(); i++){
        	int diffX, diffY;
        	if((X.get(i-1) < 0 && X.get(i) > 0) || (X.get(i-1) > 0 && X.get(i) < 0)){
        		diffX = Math.abs(X.get(i-1)) + Math.abs(X.get(i));
        	}
        	else{
        		diffX = Math.abs(Math.abs(X.get(i-1)) - Math.abs(X.get(i)));
        	}
        	
        	if((Y.get(i-1) < 0 && Y.get(i) > 0) || (Y.get(i-1) > 0 && Y.get(i) < 0)){
        		diffY = Math.abs(Y.get(i-1)) + Math.abs(Y.get(i));
        	}
        	else{
        		diffY = Math.abs(Math.abs(Y.get(i-1)) - Math.abs(Y.get(i)));
        	}
        	
            while(true){
                if(diffX == 0 && diffY==0){
                    break;
                }
                else if(diffX>0 && diffY>0){
                    diffX--;
                    diffY--;
                }
                else if(diffX > 0){
                    diffX--;
                }
                else{
                    diffY--;
                }
                totalMoves++;
            }
        }
        
        return totalMoves;
    }
	
	public static void main(String[] args){
		ArrayList<Integer> X = new ArrayList<Integer>();
		X.add(1);
		X.add(-7);
		
		ArrayList<Integer> Y = new ArrayList<Integer>();
		Y.add(-5);
		Y.add(-13);
		
		System.out.println(new MinimumSetpsInInfiniteGrid().coverPoints(X, Y));
	}
}
