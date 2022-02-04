package LeetCode525;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年02月04日
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0, n = nums.length, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0, j; i < n; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (sum == 0) {
                ans = i + 1;
            } else if ((j = map.getOrDefault(sum, -1)) == -1) {
                map.put(sum, i);
            } else {
                ans = Math.max(ans, i - j);
            }
        }
        return ans;
    }
}
