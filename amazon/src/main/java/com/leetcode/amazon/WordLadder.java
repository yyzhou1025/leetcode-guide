package com.leetcode.amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liwentian on 17/8/10.
 */

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Queue<String> next = new LinkedList<>();

        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            String word = queue.poll();

            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == word.charAt(i)) {
                        continue;
                    }
                    String s = word.substring(0, i) + c + word.substring(i + 1);

                    if (s.equals(endWord)) {
                        return level + 1;
                    }

                    if (wordList.contains(s)) {
                        wordList.remove(s);
                        System.out.println(String.format("level %d, add %s", level, s));
                        next.add(s);
                    }
                }
            }

            if (queue.isEmpty()) {
                level++;
                queue.addAll(next);
                next.clear();
            }
        }

        return 0;
    }
}
