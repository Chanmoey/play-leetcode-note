package LeetCode2007;

import java.util.Arrays;

/**
 * 错误！！！直观认为 sortChanged[i] * 2 =  sortChanged[i + half]
 *
 * @author Chanmoey
 * @date 2022年09月15日
 */
class Solution {
    public int[] findOriginalArray(int[] changed) {

        if (changed.length % 2 == 1) {
            return new int[]{};
        }

        int[] res = new int[changed.length / 2];

        Arrays.sort(changed);
        int i = 0;
        int j = changed.length / 2;
        while (j < changed.length) {
            if (changed[i] * 2 != changed[j]) {
                return new int[]{};
            }

            res[i++] = changed[j++];
        }

        return res;
    }
}
