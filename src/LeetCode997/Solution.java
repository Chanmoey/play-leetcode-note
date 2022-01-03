package LeetCode997;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年01月03日
 */
class Solution {
    public int findJudge(int n, int[][] trust) {

        if (trust.length == n || trust.length < n - 1) {
            return -1;
        }

        int[] people = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>(n * 2);

        for (int[] ints : trust) {
            people[ints[0]]++;
            map.computeIfAbsent(ints[0], key -> new ArrayList<>()).add(ints[1]);
        }

        int judge = 0;
        for (int i = 1; i <= n; i++) {
            if (people[i] == 0) {
                if (judge == 0) {
                    judge = i;
                } else {
                    return -1;
                }
            }
        }

        for (Integer integer : map.keySet()) {
            if (!map.get(integer).contains(judge)) {
                return -1;
            }
        }

        return judge;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findJudge(3, new int[][]{{1, 3}, {2, 3}});
    }
}
