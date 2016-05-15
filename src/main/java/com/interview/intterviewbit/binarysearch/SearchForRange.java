package com.interview.intterviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForRange
{
	public List<Integer> findRange(List<Integer> nums, int target){
		int beg = 0, end = nums.size() - 1, rangeBeg = -2, rangeEnd = 0;
		
		while(end >= beg){
			int mid = (beg+end)/2;
			int midVal = nums.get(mid);
			
			if(target == midVal){
				rangeBeg = mid;
				while(rangeBeg>=beg && nums.get(rangeBeg) == target){
					rangeBeg--;
				}
				rangeEnd = mid;
				while(rangeEnd<=end && nums.get(rangeEnd) == target){
					rangeEnd++;
				}
			}
			
			if(target < midVal){
				end = mid - 1;
			}
			else{
				beg = mid + 1;
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		result.add(rangeBeg+1);
		result.add(rangeEnd-1);
		
		return result;
	}
	
	public void anotherApproach(List<Integer> nums, int target){
		int beg = getIndex(nums, target);
		if(beg == nums.size() || nums.get(beg) != target){
			System.out.println("-1,-1");
		}
		else{
			int end = getIndex(nums, target + 1);
			System.out.println((beg + 1) + ", " + end);
		}
	}
	
	private int getIndex(List<Integer> nums, int target){
		int beg = 0, end = nums.size();
		
		while(end>beg){
			int mid = (beg + end)/2;
			
			if(nums.get(mid) < target){
				beg = mid + 1;
			}
			else{
				end = mid;
			}
		}
		
		return beg;
	}
	
	public static void main(String[] args){
		SearchForRange searchForRange = new SearchForRange();
//		List<Integer> r = searchForRange.findRange(Arrays.asList(5,7,7,8,8,10), 11);
//		List<Integer> r = searchForRange.findRange(Arrays.asList(5,7,7,8,8,10), 7);
//		System.out.println(r.get(0) + ", " + r.get(1));
		searchForRange.anotherApproach(Arrays.asList(5,7,7,7,9,9,10), 3);
	}
}
