package LeetCode135;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年06月13日
 */
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int res = 0;

        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        // 从左至右看
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        // 从右往左看
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1] && candy[i] >= candy[i - 1]) {
                candy[i - 1] = candy[i] + 1;
            }
        }

        // 求和
        for (int i = 0; i < n; i++) {
            res += candy[i];
        }

        return res;
    }
}
