package LeetCode287;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年03月29日
 */
class Solution2 {
    public int findDuplicate(int[] nums) {
        boolean[] set = new boolean[nums.length];
        for (int num : nums) {
            if (set[num]) {
                return num;
            } else {
                set[num] = true;
            }
        }
        return -1;
    }
}
