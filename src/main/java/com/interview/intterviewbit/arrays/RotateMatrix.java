package com.interview.intterviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix
{
	private void rotate(List<List<Integer>> a){
		int left=0,right=a.size() - 1, top=0, bottom=a.size()-1;
	    for(int i=0; i<a.size()/2; i++){

	    	for(int j=0; j<(right-left); j++){
	            int topLeft = a.get(top).get(left);
	            
	            //shifting left;
                for(int k=top;k<bottom;k++){
                    a.get(k).set(left, a.get(k+1).get(left));
                }               
                
                //shifting bottom
                for(int k=left;k<right;k++){
                    a.get(bottom).set(k, a.get(bottom).get(k+1));
                }
                
                //shifting right
                for(int k=bottom;k>top;k--){
                    a.get(k).set(right, a.get(k-1).get(right));
                }
                
                //shifting top
                for(int k=right;k>left + 1;k--){
                    a.get(top).set(k, a.get(top).get(k-1));
                }
                
                a.get(top).set(left+1, topLeft);
	        }
	    	
	    	left+=1;
	        right-=1;
	        bottom-=1;
	        top+=1;
	    }
	    
	    print(a);
	}
	
	
	private void rotate_adv(List<List<Integer>> a){
		int start = 0, end = a.size() - 1;
		for(int layer=0; layer < a.size()/2; layer ++){
			int offset = 0;
			for(int i=start; i<end; i++){
				int temp = a.get(start).get(i);
				
				a.get(start).set(i, a.get(end-offset).get(start));
				a.get(end-offset).set(start, a.get(end).get(end-offset));
				a.get(end).set(end-offset, a.get(i).get(end));
				a.get(i).set(end, temp);
				offset++;
			}
			
			start += 1;
			end -= 1;
		}
		
		print(a);
	}
	
	private void print(List<List<Integer>> a)
	{
		for(int i=0; i<a.size(); i++){
			for(int j=0;j<a.size(); j++){
				System.out.print(a.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		List<List<Integer>> a = new ArrayList<List<Integer>>();
//		a.add(Arrays.asList(1,2,3,4));
//		a.add(Arrays.asList(5,6,7,8));
//		a.add(Arrays.asList(9,10,11,12));
//		a.add(Arrays.asList(13,14,15,16));
		
		int n= 14;
		for(int i=0;i<n;i++){
			a.add(get(i+1, n));
		}
		
		new RotateMatrix().rotate_adv(a);
	}
	
	private static List<Integer> get(int n, int c){
		List<Integer> ll = new ArrayList<Integer>(c);
		for(int i=0; i<c; i++){
			ll.add(n);
		}
		
		return ll;
	}
}
