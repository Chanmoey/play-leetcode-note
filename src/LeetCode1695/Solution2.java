package LeetCode1695;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime: 9 ms, faster than 96.71% of Java online submissions for Maximum Erasure Value.
 *
 * @author Chanmoey
 * @date 2022年06月12日
 */
public class Solution2 {
    public int maximumUniqueSubarray(int[] nums) {

        int n = nums.length;
        int l = 0;
        int r = 0;

        int[] map = new int[10001];
        int sum = 0;
        int ans = 0;

        while (r < n) {
            int right = nums[r++];
            sum += right;

            map[right] ++;

            while (map[right] > 1) {
                int left = nums[l ++];
                map[left] --;
                sum -= left;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
