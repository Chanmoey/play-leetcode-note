package LeetCode2007;

import java.util.Arrays;

/**
 * 优化 Solution1
 *
 * @author Chanmoey
 * @date 2022年09月15日
 */
public class Solution2 {

    private final int[] map = new int[100001];

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[]{};
        }

        Arrays.sort(changed);

        int[] res = new int[changed.length / 2];
        int remaining = 0;
        int index = 0;
        for (int j : changed) {
            if (j % 2 == 0 && map[j / 2] > 0) {
                res[index++] = j / 2;
                map[j / 2]--;
                remaining--;
            } else {
                map[j]++;
                remaining++;
            }
        }

        if (remaining > 0) {
            return new int[]{};
        }

        return res;
    }
}
