package LeetCode91;

class Solution1 {

    /**
     * 动态规划
     * */
    public int numDecodings(String s) {

        int n = s.length();

        char charZero = '0';
        String stringZero = "0";
        if (n == 1) {
            if (stringZero.equals(s)){
                return 0;
            } else {
                return 1;
            }
        }

        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i --) {
            if (s.charAt(i) != charZero) {
                dp[i] = dp[i + 1];
                if (i + 1 < n && this.stringToInteger(s.substring(i, i + 2)) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }

    private int stringToInteger(String s) {
        return (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
    }
}
