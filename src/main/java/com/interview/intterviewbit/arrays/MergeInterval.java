package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval
{
//	public List<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
//	{
//		List<Interval> result = new ArrayList<Interval>();
//		
//		int startIndex = intervals.size(), endIndex = startIndex, start = newInterval.start, end = newInterval.end;
//		
//		for(int i=0; i<intervals.size(); i++){
//			Interval ci = intervals.get(i);
//			
//			if(start <= ci.start){
//				startIndex = i-1;
//				break;
//			}
//		}
//		
//		for(int i=0; i<intervals.size(); i++){
//			Interval ci = intervals.get(i);
//			
//			if(end <= ci.end){
//				startIndex = i;
//				break;
//			}
//		}
//		
//		if(startIndex == -1 && endIndex == -1){
//			result.add(newInterval);
//			result.addAll(intervals);
//			return result;
//		}
//		else if(startIndex == intervals.size()){
//			result.addAll(intervals);
//			result.add(newInterval);
//			return result;
//		}
//		
//		int count = 0;
//		while(count < intervals.size()){
//			if(count < startIndex || count > endIndex){
//				result.add(intervals.get(count));
//			}
//			else{
//				Interval si = startIndex == -1 ? null : intervals.get(startIndex);
//				Interval ei = endIndex == intervals.size() ? null : intervals.get(endIndex);
//				Interval temp = new Interval();
//				if(si == null){
//					temp.start = start;
//
//					if(ei == null || end <= ei.start){
//						temp.end = end;
//					}
//					else if(end <= ei.start){
//						temp.end = ei.end;
//					}
//				}
//				else if(end)
//			}
//		}
//		
//		
//		return result;
//	}
	
	public static class IntervalWrapper implements Comparable<Interval>{

	public int compareTo(Interval o)
	{
		// TODO Auto-generated method stub
		return 0;
	}
		
	}

	public static class Interval
	{
		int start;
		int end;

		Interval()
		{
			start = 0;
			end = 0;
		}

		Interval(int s, int e)
		{
			start = s;
			end = e;
		}
	}
}
