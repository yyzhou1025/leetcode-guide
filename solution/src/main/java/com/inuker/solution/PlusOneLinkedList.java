package com.inuker.solution;

import com.leetcode.library.ListNode;

import java.util.Stack;

/**
 * Created by liwentian on 2017/9/10.
 */

public class PlusOneLinkedList {

    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        for (ListNode node = head; node != null; node = node.next) {
            stack.push(node);
        }
        int k = 1;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            int val = node.val + k;
            node.val = val % 10;
            k = val / 10;
            if (k == 0) {
                return head;
            }
        }
        ListNode node = new ListNode(k);
        node.next = head;
        return node;
    }
}
