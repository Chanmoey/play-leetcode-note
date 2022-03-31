package LeetCode287;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * O(n)
 *
 * @author Chanmoey
 * @date 2022年03月29日
 */
class Solution1 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }

        return -1;
    }
}
