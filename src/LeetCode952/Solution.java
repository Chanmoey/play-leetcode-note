package LeetCode952;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmory
 * @date 2021年11月23日 9:21
 * @description 参考了讨论区的思路。
 */
class Solution {
    public int largestComponentSize(int[] nums) {
        int length = nums.length;
        int[] parent = new int[100001];
        Arrays.fill(parent, -1);

        for (int num : nums) {
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    this.union(num, j, parent);
                    this.union(num, num / j, parent);
                }
            }
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int num : nums) {
            int p = this.find(num, parent);
            count = Math.max(count, 1 + map.getOrDefault(p, 0));
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        return count;
    }

    private int find(int x, int[] parent) {
        if (parent[x] == -1) {
            return x;
        }

        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int x, int y, int[] parent) {
        int xp = this.find(x, parent);
        int yp = this.find(y, parent);
        if (xp != yp) {
            parent[yp] = xp;
        }
    }
}
