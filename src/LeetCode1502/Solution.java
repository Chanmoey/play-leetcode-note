package LeetCode1502;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年03月01日
 */
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        int tempDiff;
        for (int i = 2; i < arr.length; i++) {
            tempDiff = arr[i] - arr[i - 1];
            if (tempDiff != diff) {
                return false;
            }
        }

        return true;
    }
}
