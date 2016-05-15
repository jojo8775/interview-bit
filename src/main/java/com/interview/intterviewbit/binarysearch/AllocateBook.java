package com.interview.intterviewbit.binarysearch;

import java.util.Arrays;
import java.util.List;

public class AllocateBook
{
	public int books(List<Integer> pages, int students)
	{
		int beg = getMax(pages), end = getSum(pages), currentStudentNumber = 0;

		while (beg < end)
		{
			int mid = (beg + end) / 2;
			currentStudentNumber = getNumberOfStudent(mid, pages);

			if (currentStudentNumber <= students)
			{
				end = mid;
			} else
			{
				beg = mid + 1;
			}
		}

		return beg;
	}

	private int getMax(List<Integer> pages)
	{
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < pages.size(); i++)
		{
			max = Math.max(max, pages.get(i));
		}

		return max;
	}

	private int getSum(List<Integer> pages)
	{
		int sum = 0;
		for (int i = 0; i < pages.size(); i++)
		{
			sum += pages.get(i);
		}

		return sum;
	}

	private int getNumberOfStudent(int cap, List<Integer> pages)
	{
		int studentNumber = 1, total = 0;

		for (int i = 0; i < pages.size(); i++)
		{
			total += pages.get(i);
			if (total > cap)
			{
				studentNumber++;
				total = pages.get(i);
			}
		}

		return studentNumber;
	}

	public static void main(String[] args)
	{
		List<Integer> pages = Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9);
		System.out.println(new AllocateBook().books(pages, 5));
	}
}
