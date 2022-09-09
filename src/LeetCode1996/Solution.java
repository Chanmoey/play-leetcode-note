package LeetCode1996;

import java.util.*;

/**
 * Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年09月09日
 */
class Solution {

    Map<Integer, ArrayList<Integer>> group = new TreeMap<>();

    public int numberOfWeakCharacters(int[][] properties) {

        int res = 0;

        for (int[] property : properties) {
            if (!group.containsKey(property[0])) {
                group.put(property[0], new ArrayList<>());
            }
            group.get(property[0]).add(property[1]);
        }

        Set<Integer> keySets = group.keySet();
        for (int[] property : properties) {
            for (Integer key : keySets) {
                boolean isWeak = false;
                if (key > property[0]) {
                    List<Integer> list = group.get(key);
                    for (Integer defense : list) {
                        if (defense > property[1]) {
                            res++;
                            isWeak = true;
                            break;
                        }
                    }
                }

                if (isWeak) {
                    break;
                }
            }
        }

        return res;
    }
}
