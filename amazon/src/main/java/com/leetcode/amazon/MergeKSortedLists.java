package com.leetcode.amazon;


import com.leetcode.library.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liwentian on 17/8/11.
 */

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), cur = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                if (node1.val == node2.val) {
                    return 0;
                } else if (node1.val < node2.val) {
                    return -1;
                } else {
                    return 1;
                }
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
