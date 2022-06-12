package LeetCode1695;

import java.util.HashMap;
import java.util.Map;

/**
 * 172ms
 *
 * @author Chanmoey
 * @date 2022年06月12日
 */
public class Solution1 {
    public int maximumUniqueSubarray(int[] nums) {

        int n = nums.length;
        int l = 0;
        int r = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;

        while (r < n) {
            int right = nums[r++];
            sum += right;

            map.put(right, map.getOrDefault(right, 0) + 1);

            while (map.get(right) > 1) {
                int left = nums[l ++];
                map.put(left, map.get(left) - 1);
                sum -= left;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
