package LeetCode268;

import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Map;

/**
 * O(2n) -> O(n), HashMap
 *
 * @author Chanmoey
 * @date 2022年04月20日
 */
class Solution {
    public int missingNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length * 2);

        for (int n : nums) {
            map.put(n, 1);
        }

        for (int i = 0; i <= nums.length + 1; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }

        return -1;
    }
}
