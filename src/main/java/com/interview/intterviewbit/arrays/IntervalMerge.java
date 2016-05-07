package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalMerge
{
	public List<Interval> sol(List<Interval> intervals, Interval newInterval)
	{

		int startIndex = intervals.size(), endIndex = -1, start = newInterval.start, end = newInterval.end;

		for (int i = 0; i < intervals.size(); i++)
		{
			Interval curInterval = intervals.get(i);
			if (start <= curInterval.start)
			{
				startIndex = Math.min(startIndex, i);
			}

			if (end >= curInterval.end)
			{
				endIndex = Math.min(endIndex, i);
			}

			if (startIndex != Integer.MAX_VALUE && endIndex != Integer.MAX_VALUE)
			{
				break;
			}
		}

		List<Interval> result = new ArrayList<Interval>();
		if (startIndex == -1 && endIndex == -1)
		{
			result.add(newInterval);
			result.addAll(intervals);
			return result;
		}

		if (startIndex == Integer.MAX_VALUE && endIndex == Integer.MAX_VALUE)
		{
			result.addAll(intervals);
			result.add(newInterval);
			return result;
		}

		for (int i = 0; i < startIndex; i++)
		{
			result.add(intervals.get(i));
		}
		
		if(start >= intervals.get(startIndex).end){
			result.add(intervals.get(startIndex));
		}else{
			start = intervals.get(startIndex).start;
		}
		
		if(end > intervals.get(endIndex).start){
			end = Math.max(end, intervals.get(endIndex).end);
		}
		
		result.add(new Interval(start, end));
		

		return result;
	}

	public static void main(String[] args)
	{
		IntervalMerge m = new IntervalMerge();
		// List<Interval> ll = Arrays.asList(new Interval(2, 4), new Interval(6,
		// 9));
		// print(m.sol(ll, new Interval(2, 5)));
		// print(m.sol(ll, new Interval(1, 1)));
		// print(m.sol(ll, new Interval(9, 10)));
		//
		// List<Interval> l1 = Arrays.asList(new Interval(1, 2), new Interval(3,
		// 5), new Interval(6, 7), new Interval(8, 10), new Interval(12, 16));
		// print(m.sol(l1, new Interval(4, 9)));

		List<Interval> l2 = Arrays.asList(new Interval(2, 4), new Interval(8, 9));
		print(m.sol(l2, new Interval(5, 6)));
	}

	private static void print(List<Interval> intervals)
	{
		for (Interval i : intervals)
		{
			System.out.println(i.toString());
		}
		System.out.println("-------------------------");
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

		@Override
		public String toString()
		{
			return "Interval [start=" + start + ", end=" + end + "]";
		}
	}
}
