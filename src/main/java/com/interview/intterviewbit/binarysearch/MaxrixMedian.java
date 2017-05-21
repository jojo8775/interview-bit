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
}
