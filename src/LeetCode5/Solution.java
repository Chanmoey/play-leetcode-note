package LeetCode5;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Limit Exceeded
 */
class Solution {
    public String longestPalindrome(String s) {

        if (s.length() == this.palindromeLength(s)) {
            return s;
        } else {
            List<String> list = this.getAllSubString(s);
            String sub = "";
            int result = 1;
            for (String s1 : list) {
                int newLength = this.palindromeLength(s1);
                if (newLength >= result) {
                    sub = s1;
                    result = newLength;
                }
            }
            return sub;
        }

    }

    public List<String> getAllSubString(String s) {
        List<String> list = new ArrayList<>();

        if (s.length() == 1) {
            list.add(s);
            return list;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                list.add(s.substring(i, j));
            }
        }

        return list;
    }

    private int palindromeLength(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int i = 0, j = s.length() - 1;
        boolean isPalindrome = true;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            return s.length();
        }

        return 0;
    }

    public static void main(String[] args) {
        String s = "avv";
        Solution solution = new Solution();
        String s1 = solution.longestPalindrome(s);
        System.out.println(s1);
    }
}
