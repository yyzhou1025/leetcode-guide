package com.leetcode.amazon;

import java.util.HashMap;

/**
 * Created by liwentian on 17/8/9.
 */

public class LRUCache {

    private int mCapacity;

    private ListNode mHead;

    private HashMap<Integer, ListNode> mMap;

    public LRUCache(int capacity) {
        mCapacity = capacity;
        mHead = new ListNode();
        mMap = new HashMap<>();
    }

    public int get(int key) {
        ListNode node = mMap.get(key);
        if (node == null) {
            return -1;
        }
        node.remove();
        mHead.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = mMap.get(key);

        if (node != null) {
            node.remove();
            mHead.add(node);
            node.value = value;
        } else {
            if (mMap.size() >= mCapacity) {
                node = mHead.prev;
                node.remove();
                mMap.remove(node.key);
            }
            node = new ListNode();
            node.key = key;
            node.value = value;
            mMap.put(key, node);
            mHead.add(node);
        }
    }

    private class ListNode {
        ListNode prev, next;

        int key, value;

        ListNode() {
            prev = this;
            next = this;
        }

        void remove() {
            prev.next = next;
            next.prev = prev;
        }

        void add(ListNode node) {
            node.next = next;
            next.prev = node;

            node.prev = this;
            this.next = node;
        }
    }
}
