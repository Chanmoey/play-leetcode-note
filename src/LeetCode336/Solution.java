package LeetCode336;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力解法，不出意外的 Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年09月17日
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j == i) {
                    continue;
                }

                String str1 = words[i] + words[j];
                if (isPalindrome(str1)) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String str) {
        boolean palindrome = true;
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                palindrome = false;
                break;
            }
            i++;
            j--;
        }

        return palindrome;
    }
}
