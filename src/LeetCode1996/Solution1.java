package LeetCode1996;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年09月09日
 */
class Solution1 {

    Map<Integer, TreeMap<Integer, Integer>> group = new TreeMap<>();

    public int numberOfWeakCharacters(int[][] properties) {

        int n = properties.length;

        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });

        int weak = Integer.MIN_VALUE;
        int res = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (properties[i][1] < weak) {
                res ++;
            }

            weak = Math.max(weak, properties[i][1]);
        }

        return res;
    }
}
