package LeetCode647;

/**
 * @author Chanmoey
 * @date 2022年05月22日
 */
class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        int count = 0;

        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            count++;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + 1 == i && s.charAt(j) == s.charAt(i)
                        || dp[j + 1][i - 1] == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = 1;
                    count++;
                }
            }
        }

        return count;
    }
}
