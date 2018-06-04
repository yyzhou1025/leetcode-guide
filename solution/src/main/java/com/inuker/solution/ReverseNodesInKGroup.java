package com.inuker.solution;

import com.leetcode.library.ListNode;

/**
 * Created by dingjikerbo on 2016/11/24.
 */

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode node = head; node != null; node = node.next, n++);
        ListNode dummy = new ListNode(0), cur = dummy, node = head;
        for ( ; n >= k; n -= k) {
            ListNode tail = node, next;
            for (int i = 0; i < k; i++) {
                next = node.next;
                node.next = cur.next;
                cur.next = node;
                node = next;
            }
            cur = tail;
        }
        cur.next = node;
        return dummy.next;
    }
}
