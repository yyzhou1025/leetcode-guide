package com.inuker.solution;

import com.leetcode.library.ListNode;

/**
 * Created by dingjikerbo on 2016/11/17.
 * https://leetcode.com/articles/linked-list-cycle/
 */

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        for (ListNode fast = head, slow = head; fast != null && fast.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
