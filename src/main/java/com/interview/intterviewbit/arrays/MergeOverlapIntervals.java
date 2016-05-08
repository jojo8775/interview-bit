package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeOverlapIntervals
{
	public List<Interval> mergeIntervals(List<Interval> intervals)
	{
		Collections.sort(intervals, new IntervalComparator());
		
		List<Interval> result = new ArrayList<Interval>();
		
		Interval prev = intervals.get(0);
		
		for(int i=1; i<intervals.size(); i++){
			Interval current = intervals.get(i);
			
			if(prev.end >= current.start){
				Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));
				prev = merged;
			}
			else{
				result.add(prev);
				prev = current;
			}
		}
		
		result.add(prev);
		
		return result;
	}

	private static class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval i1, Interval i2){
			return i1.start - i2.start;
		}
	}
	
	private static class Interval
	{
		public int start;
		public int end;

		public Interval(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
	}
}
