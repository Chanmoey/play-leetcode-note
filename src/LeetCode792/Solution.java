package LeetCode792;

/**
 * O(n²) -> Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年07月20日
 */
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isSubsequence(s, word)) {
                res++;
            }
        }

        return res;
    }

    private boolean isSubsequence(String origin, String target) {
        if (target.length() > origin.length()) {
            return false;
        }

        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == target.charAt(j)) {
                j++;
                if (j == target.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
