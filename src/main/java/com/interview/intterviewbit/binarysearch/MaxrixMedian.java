package com.interview.intterviewbit.binarysearch;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {

        if (A.size() == 0) {
            return 0;
        }

        int idx = (A.size() * A.get(0).size()) / 2 + 1;

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((int[] a, int[] b) -> a[0] - b[0]);
        for (int i = 0; i < A.size(); i++) {
            queue.offer(new int[] { A.get(i).get(0), i, 0 });
        }

        int median = 0;
        for (int i = 0; i < idx; i++) {
            int[] top = queue.poll();
            median = top[0];

            if (top[2] + 1 < A.get(top[1]).size()) {
                queue.offer(new int[] { A.get(top[1]).get(top[2] + 1), top[1], top[2] + 1 });
            }
        }

        return median;
    }

    public int findMedian_SecondApproach(ArrayList<ArrayList<Integer>> A) {
int m = A.size(), n = A.get(0).size();
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            min = Math.min(A.get(i).get(0), min);
            max = Math.max(A.get(i).get(n - 1), max);
        }
        
        int medianIdx = (m * n  + 1 )/ 2;

        while (min < max) {
            int mid = min + (max - min) / 2;

            int count = 0;
            for (int i = 0; i < m; i++) {
                count += binarySearch(A.get(i), mid);
            }
            
            if (count < medianIdx) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    private int binarySearch(ArrayList<Integer> A, int target){
        int beg = 0, end = A.size();
        
        while(beg < end){
            int mid = beg + (end - beg)/2;
            if(A.get(mid) <= target){
                beg = mid + 1;
            }
            else{
                end = mid;
            }
        }
        
        return beg;
    }
    
    public static void main(String[] args){
        int[][] arr = {{1,3,5},{2,6,9},{3,6,9}};
        System.out.println(new MaxrixMedian().findMedian_SecondApproach(createArrayList(arr)));
    }
    
    private static ArrayList<ArrayList<Integer>> createArrayList(int[][] arr){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int[] a : arr){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int n : a){
                list.add(n);
            }
            
            result.add(list);
        }
        
        return result;
    }
}
