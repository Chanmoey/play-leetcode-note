package LeetCode1392;

/**
 * @author Chanmoey
 * @date 2023年01月09日
 */
class Solution {

    private static final long MOD = (long) (1e9 + 7);

    public String longestPrefix(String s) {

        long[] pow26 = new long[s.length()];
        pow26[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            pow26[i] = pow26[i - 1] * 26 % MOD;
        }

        // preHash[i]: hash(s[0...i]
        long[] preHash = new long[s.length()];
        preHash[0] = s.charAt(0) - 'a';
        for (int i = 1; i < s.length(); i++) {
            preHash[i] = (preHash[i - 1] * 26 + s.charAt(i) - 'a') % MOD;
        }

        // postHash[i]: hash(s[i...s.length - 1]
        long[] postHash = new long[s.length()];
        postHash[s.length() - 1] = s.charAt(s.length() - 1) - 'a';
        for (int i = s.length() - 2; i >= 0; i--) {
            postHash[i] = ((s.charAt(i) - 'a') * pow26[s.length() - i - 1] + postHash[i + 1]) % MOD;
        }

        // s[0...len - 1] 和 s[s.length - len, s.length - 1]
        for (int len = s.length() - 1; len >= 1; len--) {
            if (preHash[len - 1] == postHash[s.length() - len] &&
                    equal(s, 0, len - 1, s.length() - len, s.length() - 1)) {
                return s.substring(0, len);

            }
        }

        return "";
    }

    private boolean equal(String s, int l1, int r1, int l2, int r2) {
        for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
