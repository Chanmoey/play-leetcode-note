package LeetCode752;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年03月03日
 */
class Solution {

    private static final String START = "0000";

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        if (deadSet.contains(target) || deadSet.contains(START)) {
            return -1;
        }
        if (START.equals(target)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        queue.add(START);
        visited.put(START, 0);

        while (!queue.isEmpty()) {
            String cur = queue.remove();

            ArrayList<String> nexts = new ArrayList<>();
            char[] curChar = cur.toCharArray();
            for (int i = 0; i < curChar.length; i++) {
                char o = curChar[i];
                curChar[i] = Character.forDigit((curChar[i] - '0' + 1) % 10, 10);
                nexts.add(new String(curChar));
                curChar[i] = o;

                // 相当于减 1，避免出现负值。
                curChar[i] = Character.forDigit((curChar[i] - '0' + 9) % 10, 10);
                nexts.add(new String(curChar));
                curChar[i] = o;
            }

            for (String next : nexts) {
                if (!deadSet.contains(next) && !visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(cur) + 1);
                    if (next.equals(target)) {
                        return visited.get(next);
                    }
                }
            }
        }

        return -1;
    }
}
