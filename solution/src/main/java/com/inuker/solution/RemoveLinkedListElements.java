package com.inuker.solution;

import com.leetcode.library.ListNode;

/**
 * Created by dingjikerbo on 2016/12/20.
 */

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0), node = dummy;
        for ( ; head != null; head = head.next) {
            if (head.val != val) {
                node.next = head;
                node = node.next;
            }
        }
        node.next = null;
        return dummy.next;
    }
}
