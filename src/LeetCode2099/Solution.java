package LeetCode2099;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年05月16日
 */
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (k >= nums.length) {
            return nums;
        }
        int[] arr = nums.clone();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>(2 * k);

        int i = 0;
        int j = nums.length - 1;
        while (i < k) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            j--;
            i++;
        }

        int[] res = new int[k];
        i = 0;
        for (int num : arr) {
            if (map.containsKey(num) && map.get(num) > 0) {
                res[i] = num;
                i++;
                map.put(num, map.get(num) - 1);
                if (i == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
