package LeetCode28;

/**
 * 这里使用KMP算法
 * */

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty()) {
            return needle.isEmpty() ? 0 : -1;
        }

        if (needle.isEmpty()) {
            return 0;
        }

        int[] next = this.getNext(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - needle.length();
                }
            } else if (j != 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }

        return -1;

    }

    private int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;

        int len = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                next[i++] = ++len;
            } else if (len != 0) {
                len = next[len - 1];
            } else {
                i++;
            }
        }

        return next;
    }
}
