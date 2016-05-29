package com.interview.intterviewbit.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsOnAStraightLine
{
	//need to find the same slope and then need to consider the vertical and duplicate points.
	public int maxPoints(List<Integer> p1, List<Integer> p2){
		
		int result = 0;
		
		for(int i=0; i<p1.size() - 1; i++){
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			int duplicate = 1, verticle = 0;
			for(int j=i+1; j<p1.size(); j++){
				if(p1.get(i)==p1.get(j)){
					if(p2.get(i) == p2.get(j)){
						duplicate++;
					}
					else{
						verticle++;
					}
				}
				else{
					double slope = (p2.get(j) - p2.get(i)) == 0 ? 0.0 : (1.0*(p2.get(j) - p2.get(i)))/(p1.get(j) - p1.get(i));
					if(map.containsKey(slope)){
						map.put(slope, map.get(slope) + 1);
					}
					else{
						map.put(slope, 1);
					}
				}
			}
			
			for(int val : map.values()){
				result = Math.max(result, val + duplicate);
			}
			
			result = Math.max(result, duplicate + verticle);
		}
		
		
		return result;
	}
	
	public static void main(String[] args){
//		int r = new PointsOnAStraightLine().maxPoints(Arrays.asList(1,1,1,1,1), Arrays.asList(1,1,1,1,1));
		int r = new PointsOnAStraightLine().maxPoints(Arrays.asList(3,1,-1), Arrays.asList(3,1,-1));
		
		System.out.println(r);
	}
}
