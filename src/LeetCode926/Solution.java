package LeetCode926;

/**
 * @author Chanmoey
 * @date 2023年01月18日
 */
class Solution {
    public int minFlipsMonoIncr(String s) {
        // 规定把左边变成0，右边变成1
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                m++;
            }
        }

        int res = m;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res = Math.min(res, --m);
            } else {
                m++;
            }
        }

        return res;
    }
}
