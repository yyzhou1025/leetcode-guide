package com.leetcode.google;

import com.leetcode.library.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liwentian on 2017/9/2.
 */

public class CloneGraph {

//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        return dfs(node, new HashMap<>());
//    }
//
//    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
//        if (node == null) {
//            return null;
//        }
//        if (map.containsKey(node)) {
//            return map.get(node);
//        }
//
//        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
//        map.put(node, copy);
//
//        for (UndirectedGraphNode child : node.neighbors) {
//            UndirectedGraphNode childCopy = dfs(child, map);
//            copy.neighbors.add(childCopy);
//        }
//
//        return copy;
//    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode node1 = queue.poll();
            UndirectedGraphNode cloned = map.get(node1);

            for (UndirectedGraphNode p : node1.neighbors) {
                if (!map.containsKey(p)) {
                    map.put(p, new UndirectedGraphNode(p.label));
                    queue.add(p);
                }
                cloned.neighbors.add(map.get(p));
            }
        }

        return newNode;
    }
}
