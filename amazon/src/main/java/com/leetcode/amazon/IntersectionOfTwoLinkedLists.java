package com.leetcode.amazon;

import com.leetcode.library.ListNode;

/**
 * Created by liwentian on 17/8/10.
 */

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        for (ListNode node = headA; node != null; node = node.next) {
            lenA++;
        }
        for (ListNode node = headB; node != null; node = node.next) {
            lenB++;
        }
        ListNode node1 = lenA > lenB ? headA : headB;
        ListNode node2 = lenA > lenB ? headB : headA;

        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            node1 = node1.next;
        }

        while (node1 != null && node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }
}
