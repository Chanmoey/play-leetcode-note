package LeetCode948;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年09月12日
 */
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length - 1;
        int scores = 0;
        int ans = 0;

        while (l <= r && (scores > 0 || power >= tokens[l])) {
            while (l <= r && power >= tokens[l]) {
                power -= tokens[l];
                l++;
                ++scores;
            }
            ans = Math.max(ans, scores);

            if (l <= r && scores > 0) {
                power += tokens[r];
                r--;
                --scores;
            }
        }

        return ans;
    }
}
