package LeetCode1641;

/**
 * @author Chanmoey
 * @date 2022年05月11日
 */
class Solution {
    public int countVowelStrings(int n) {
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        for (int j = 1; j < n; j++) {
            o = o + u;
            i = i + o;
            e = e + i;
            a = a + e;
        }
        return a + e + i + o + u;
    }
}
