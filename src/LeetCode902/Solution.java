package LeetCode902;

/**
 * @author Chanmoey
 * @date 2021年12月18日 9:34
 * @description
 */
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {

        StringBuilder sb = new StringBuilder();
        for (String digit : digits) {
            sb.append(digit.charAt(0));
        }

        String num = String.valueOf(n);
        int res = this.dfs(num, sb.toString());

        for (int i = 1; i < num.length(); i++) {
            res += Math.pow(digits.length, i);
        }

        return res;
    }

    private int dfs(String n, String digits) {
        if (n.length() == 0) {
            return 1;
        }

        int res = 0;
        for (char c : digits.toCharArray()) {
            if (c - '0' == n.charAt(0) - '0') {
                res += dfs(n.substring(1), digits);
            } else if (c - '0' < n.charAt(0) - '0') {
                res += Math.pow(digits.length(), n.length() - 1);
            }
        }

        return res;
    }
}
