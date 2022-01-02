package LeetCode1010;

/**
 * 时间复杂度为O(n²), TLE.
 *
 * @author Chanmoey
 * @date 2022年01月02日
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        for (int i = 1; i < time.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ((time[i] + time[j]) % 60 == 0) {
                    res++;
                }
            }
        }

        return res;
    }
}
