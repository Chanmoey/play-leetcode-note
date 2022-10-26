package LeetCode523;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力解法：不出意料的 Time Limit Exceeded。
 *
 * @author Chanmoey
 * @date 2022年10月26日
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        List<Long> list = new ArrayList<>();
        list.add((long) nums[0]);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if ((list.get(j) + nums[i]) % k == 0) {
                    return true;
                }
                list.set(j, list.get(j) + nums[i]);
            }
            list.add((long) nums[i]);
        }

        return false;
    }
}
