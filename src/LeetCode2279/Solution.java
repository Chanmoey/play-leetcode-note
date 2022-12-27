package LeetCode2279;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年12月27日
 */
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(capacity);

        int res = 0;
        for (int j : capacity) {
            if (j == 0) {
                res++;
            } else {
                if (additionalRocks >= j) {
                    additionalRocks -= j;
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
