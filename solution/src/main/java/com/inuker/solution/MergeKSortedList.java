package com.inuker.solution;

import com.leetcode.library.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dingjikerbo on 16/11/20.
 * https://leetcode.com/articles/merge-k-sorted-list/
 */

public class MergeKSortedList {

    // 耗时19ms
    // 时间复杂度为O(knlgn)
    /**
     * 这里要注意lists中可能有node为null
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), cur = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }
}
