package LeetCode336;

import java.util.ArrayList;
import java.util.List;

/**
 * 对 Solution 的一点优化，通过了更多的测试用例，还是 TLE。
 *
 * @author Chanmoey
 * @date 2022年09月17日
 */
class Solution1 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (j == i) {
                    continue;
                }

                String str1 = words[i] + words[j];
                if (isPalindrome(str1)) {
                    res.add(List.of(i, j));
                }

                String str2 = words[j] + words[i];
                if (isPalindrome(str2)) {
                    res.add(List.of(j, i));
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
