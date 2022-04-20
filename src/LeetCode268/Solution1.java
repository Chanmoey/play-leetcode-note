package LeetCode268;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年04月20日
 */
class Solution1 {
    public int missingNumber(int[] nums) {
        return  ((nums.length + 1)) * nums.length / 2 - Arrays.stream(nums).sum();
    }
}
