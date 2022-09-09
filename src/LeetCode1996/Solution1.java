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
                // 防御力倒序排序
                return b[1] - a[1];
            } else {
                // 攻击力正序排序
                return a[0] - b[0];
            }
        });

        // 排序之前：[[1, 5], [10, 4], [4, 3]]
        // 排序之后：[[1, 5], [4, 3], [10, 4]]

        int weak = Integer.MIN_VALUE;
        int res = 0;

        // 从后往前看，我们记录的 weak 其实就是防御值，但是这个防御值的攻击力一定是大于前面的。
        // 所以从后往前查询时，看到有防御值比 weak 还小，那就是一个严格的 weak character。
        for (int i = n - 1; i >= 0; i--) {
            if (properties[i][1] < weak) {
                res ++;
            }

            weak = Math.max(weak, properties[i][1]);
        }

        return res;
    }
}
