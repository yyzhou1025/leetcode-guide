package com.leetcode.amazon;

import com.leetcode.library.ListNode;

/**
 * Created by liwentian on 17/8/11.
 */

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        for (ListNode fast = head; fast != null && fast.next != null && fast.next.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode node = reverse(slow.next);
        slow.next = null;

        for ( ; head != null && node != null; head = head.next, node = node.next) {
            if (head.val != node.val) {
                return false;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
