package LeetCode2389;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Chanmoey
 * @date 2022年12月25日
 */
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, i + 1);
        }

        int[] res = new int[queries.length];

        Integer[] keys = map.keySet().toArray(new Integer[0]);

        int index = 0;
        for (int query : queries) {
            int l = 0;
            int r = keys.length - 1;
            while (l <= r) {
                int mid = l + (r - l + 1) / 2;
                if (keys[mid] == query) {
                    l = mid;
                    break;
                } else if (keys[mid] > query) {
                    r = mid - 1;
                } else {
                    // 不能保证 keys[mid + 1] < query
                    l = mid;
                }
            }
            if (keys[l] > query) {
                res[index] = 0;
            } else {
                res[index] = map.get(keys[l]);
            }
            index++;
        }

        return res;
    }
}
