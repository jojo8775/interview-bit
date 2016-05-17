package com.interview.intterviewbit.binarysearch;

import java.util.Arrays;
import java.util.List;

public class RotatedBinarySearch
{
	public int search(final List<Integer> a, int b) {
	    int beg = 0, end = a.size()-1;
	    
	    while(beg <= end){
	        int mid = (beg + end) >> 1;
	        int midVal = a.get(mid);
	        
	        if(midVal == b){
	        	return mid;
	        }
	        
	        if(midVal < b){
	            if(a.get(end) <= b){
	                end = mid - 1;
	            }
	            else{
	                beg = mid + 1;
	            }
	        }
	        else{
	            if(a.get(beg) >= b){
                    beg = mid + 1;	                
	            }
	            else{
	                end = mid - 1;
	            }
	        }
	    }
	    
	    return -1;
	}
	
	public static void main(String[] args){
//		List<Integer> list = Arrays.asList(4,5,1,2,3);
//		List<Integer> list = Arrays.asList(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100);
		List<Integer> list = Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177);
		find(list, 42);
		int r = new RotatedBinarySearch().search(list, 42);
		System.out.println(r);
	}
	
	private static void find(List<Integer> l, int num){
		for(int i=0; i<l.size(); i++){
			if(l.get(i) == num){
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}

	//180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177
}
