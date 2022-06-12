package LeetCode1695;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Time Limit Exceeded.
 *
 * @author Chanmoey
 * @date 2022年06月12日
 */
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length * 2);

        int max = 0;
        int i = 0;
        while (i < nums.length) {
            map.put(nums[i], i);

            int j = i + 1;
            for (; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    Set<Integer> set = map.keySet();
                    max = Math.max(max, this.sumOfSet(set));

                    // 重置下次循环的开始节点
                    i = map.get(nums[j]) + 1;

                    // 清空map
                    map.clear();
                    break;
                } else {
                    map.put(nums[j], j);
                }
            }

            if (j == nums.length) {
                Set<Integer> set = map.keySet();
                max = Math.max(max, this.sumOfSet(set));
                break;
            }
        }

        return max;
    }

    private int sumOfSet(Set<Integer> set) {
        int sum = 0;
        for (Integer num : set) {
            sum += num;
        }

        return sum;
    }
}
