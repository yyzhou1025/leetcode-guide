package com.leetcode.amazon;

import com.leetcode.library.ListNode;

/**
 * Created by liwentian on 17/8/11.
 */

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (ListNode p1 = l1, p2 = l2; p1 != null || p2 != null; ) {
            if (p1 == null) {
                cur.next = p2;
                break;
            }
            if (p2 == null) {
                cur.next = p1;
                break;
            }
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
