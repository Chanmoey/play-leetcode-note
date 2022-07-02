package LeetCode1465;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年07月03日
 */
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int) (1e9 + 7);

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = getMaxDiff(h, horizontalCuts);
        int maxW = getMaxDiff(w, verticalCuts);

        return (int) (((long) maxH * maxW) % mod);
    }

    private int getMaxDiff(int length, int[] cuts) {
        int diff = cuts[0];
        for (int i = 1; i < cuts.length; i++) {
            diff = Math.max(cuts[i] - cuts[i - 1], diff);
        }
        diff = Math.max(length - cuts[cuts.length - 1], diff);

        return diff;
    }
}
