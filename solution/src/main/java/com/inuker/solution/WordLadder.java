package com.inuker.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

/**
 * TestCases
 "a", "c", ["a", "b", "c"]
 "hit", "cog", ["hot","cog","dot","dog","hit","lot","log"]
 "hit", "cog", ["hot","hit","cog","dot","dog"]
 "red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
 */
public class WordLadder {

    /**
     * 要注意添加节点时要给单词从dict中删掉
     */
    // 常规的BFS，耗时141ms
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.remove(beginWord);
        wordList.add(endWord);

        Queue<String> queue = new LinkedList<>();
        Queue<String> next = new LinkedList<>();
        queue.add(beginWord);

        int ladder = 1;

        while (!queue.isEmpty()) {
            String word = queue.poll();

            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for (int j = 0; j < 26; j++) {
                    if (j + 'a' == c) {
                        continue;
                    }
                    sb.setCharAt(i, (char) (j + 'a'));
                    String s = sb.toString();

                    if (s.equals(endWord)) {
                        return ladder + 1;
                    }

                    if (wordList.remove(s)) {
                        next.add(s);
                    }
                }
                sb.setCharAt(i, c);
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                ladder++;
            }
        }

        return 0;
    }

    // 采用双端BFS，耗时28ms
    // 假设每层分叉因子为k，一共n层，则BFS时间复杂度为O(k^n)，双端BFS时间复杂度为O(2 * k^(n / 2))，显然要快得多
    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<String>();
        endSet.add(endWord);

        int length = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<String>();

            for (String word : beginSet) {
                char[] wordArr = word.toCharArray();

                for (int i = 0; i < wordArr.length; i++) {
                    char c = wordArr[i];

                    for (int j = 0; j < 26; j++) {
                        if ('a' + j == c) {
                            continue;
                        }
                        wordArr[i] = (char) ('a' + j);
                        String s = String.valueOf(wordArr);

                        if (endSet.contains(s)) {
                            return length + 1;
                        }

                        if (wordList.contains(s)) {
                            nextSet.add(s);
                            wordList.remove(s);
                        }
                    }

                    wordArr[i] = c;
                }
            }

            beginSet = nextSet;
            length++;
        }

        return 0;
    }
}
