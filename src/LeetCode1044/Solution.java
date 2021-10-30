package LeetCode1044;

class Solution {
    public String longestDupSubstring(String s) {

        int subStart = 0, maxSubLen = 0;

        for (int start = 0, end = 0; end < s.length(); end++) {

            if (maxSubLen >= (end - start + 1)) {
                break;
            }

            String pattern = s.substring(start, end + 1);
            if (s.substring(start + 1).contains(pattern) && pattern.length() > maxSubLen) {
                subStart = start;
                maxSubLen = pattern.length();
            } else {
                start ++;
            }

        }

        return s.substring(subStart, subStart + maxSubLen);
    }
}
