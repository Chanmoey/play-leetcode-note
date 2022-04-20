package LeetCode268;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年04月20日
 */
class Solution4 {
    public int missingNumber(int[] nums) {
        return  ((nums.length + 1)) * nums.length / 2 - Arrays.stream(nums).parallel().sum();
    }
}
