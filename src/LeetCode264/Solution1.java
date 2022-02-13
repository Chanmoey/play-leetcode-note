package LeetCode264;

/**
 * @author Chanmoey
 * @date 2022年02月13日
 */
class Solution1 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int twoIndex = 0, threeIndex = 0, fiveIndex = 0;
        int two, three, five;
        dp[0] = 1;
        int min;

        for (int i = 1; i < n; i++) {
            two = dp[twoIndex] * 2;
            three = dp[threeIndex] * 3;
            five = dp[fiveIndex] * 5;

            min = Math.min(two, Math.min(three, five));
            dp[i] = min;

            if (min == two) {
                twoIndex++;
            }
            if (min == three) {
                threeIndex++;
            }
            if (min == five) {
                fiveIndex++;
            }
        }

        return dp[n - 1];
    }
}
