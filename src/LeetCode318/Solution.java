package LeetCode318;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年05月29日
 */
class Solution {
    public int maxProduct(String[] words) {

        // 因为觉得 长 * 长 = 最长，所以进行了排序，其实排序是不需要的。
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        int n = words.length;
        int[] masks = new int[n];

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                masks[i] |= (1 << (c - 'a'));
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j ++) {
                if ((masks[i] & masks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}
