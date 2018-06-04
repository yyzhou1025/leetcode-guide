package com.inuker.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        /**
         * 注意这里要用双端队列，因为后面要生成路径需要从前往后
         */
        Deque<String> queue = new LinkedList<>();
        for (String s : ss) {
            /**
             * 注意这里别掉了s为空的情况，比如"//"时s会为空
             */
            if (s.length() == 0 || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!queue.isEmpty()) {
                    /**
                     * 这里和下面都别用stack或者push，因为他们都是在头部操作而非尾部
                     */
                    queue.pollLast();
                }
            } else {
                queue.offerLast(s);
            }
        }
        /**
         * 这里要注意queue可能为空，不过好在join会返回空
         */
        return "/" + String.join("/", queue);
    }
}
