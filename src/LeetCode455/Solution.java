package LeetCode455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = g.length - 1, sIndex = s.length - 1, res = 0;

        while (gIndex >= 0 && sIndex >= 0) {
            if (s[sIndex] >= g[gIndex]) {
                res++;
                gIndex--;
                sIndex--;
            } else {
                gIndex--;
            }
        }

        return res;
    }
}
