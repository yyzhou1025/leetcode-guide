package com.leetcode.amazon;

import com.leetcode.library.ListNode;

/**
 * Created by liwentian on 17/8/11.
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0), node = dummy;

        int flag = 0;
        for (ListNode p1 = l1, p2 = l2; p1 != null || p2 != null || flag > 0; ) {
            int n1 = p1 != null ? p1.val : 0;
            int n2 = p2 != null ? p2.val : 0;
            int sum = n1 + n2 + flag;
            ListNode p = new ListNode(sum % 10);
            flag = sum / 10;
            node.next = p;
            node = node.next;

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        return dummy.next;
    }
}
