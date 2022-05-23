package LeetCode474;

/**
 * @author Chanmoey
 * @date 2022年05月23日
 */
class Solution1 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = this.count01(str);

            for (int count0 = m; count0 >= 0; count0--) {
                for (int count1 = n; count1 >= 0; count1--) {
                    if (count0 < count[0] || count1 < count[1]) {
                        continue;
                    }
                    memo[count0][count1] = Math.max(memo[count0][count1], memo[count0 - count[0]][count1 - count[1]] + 1);
                }
            }
        }

        return memo[m][n];
    }

    private int[] count01(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0') {
                res[0] ++;
            } else if (c == '1') {
                res[1] ++;
            }
        }

        return res;
    }
}
