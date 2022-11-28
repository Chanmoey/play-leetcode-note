package LeetCode2225;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年11月28日
 */
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> loseZero = new HashSet<>();
        Set<Integer> loseOne = new HashSet<>();
        Map<Integer, Integer> loser = new HashMap<>();

        for (int[] match : matches) {
            loser.put(match[1], loser.getOrDefault(match[1], 0) + 1);
            if (loser.get(match[1]) == 1) {
                loseOne.add(match[1]);
            } else {
                loseOne.remove(match[1]);
            }
            loseZero.remove(match[1]);
            if (!loser.containsKey(match[0])) {
                loseZero.add(match[0]);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(loseZero.stream().sorted().toList());
        res.add(loseOne.stream().sorted().toList());
        return res;
    }
}
