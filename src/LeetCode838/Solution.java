package LeetCode838;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年09月27日
 */
class Solution {
    public String pushDominoes(String dominoes) {

        int n = dominoes.length();

        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, Integer.MAX_VALUE);
        Arrays.fill(r, Integer.MAX_VALUE);

        if (dominoes.charAt(n - 1) == 'L') {
            l[n - 1] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (dominoes.charAt(i) == 'R') {
                continue;
            }

            if (dominoes.charAt(i) == 'L') {
                l[i] = 0;
            } else if (l[i + 1] != Integer.MAX_VALUE) {
                l[i] = 1 + l[i + 1];
            }
        }

        if (dominoes.charAt(0) == 'R') {
            r[0] = 0;
        }

        for (int i = 1; i < n; i++) {
            if (dominoes.charAt(i) == 'L') {
                continue;
            }

            if (dominoes.charAt(i) == 'R') {
                r[i] = 0;
            } else if (r[i - 1] != Integer.MAX_VALUE) {
                r[i] = 1 + r[i - 1];
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (l[i] == r[i]) {
                res.append('.');
            } else if (l[i] < r[i]) {
                res.append('L');
            } else {
                res.append('R');
            }
        }

        return res.toString();
    }
}
