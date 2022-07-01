package LeetCode1710;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年07月01日
 */
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int res = 0;
        for (int[] box : boxTypes) {
            if (box[0] < truckSize) {
                res += box[0] * box[1];
                truckSize -= box[0];
            } else {
                res += truckSize * box[1];
                break;
            }
        }

        return res;
    }
}
