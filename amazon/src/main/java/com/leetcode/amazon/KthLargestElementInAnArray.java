package com.leetcode.amazon;

import java.util.PriorityQueue;

/**
 * Created by liwentian on 17/8/11.
 */

public class KthLargestElementInAnArray {

    // nlgn
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
