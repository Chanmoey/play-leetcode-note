package LeetCode1768;

/**
 * @author Chanmoey
 * @date 2022年03月05日
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] chars = new char[word1.length() + word2.length()];

        int i = 0, j = 0, k = 0;
        boolean isWord1 = true;
        while (i < word1.length() && j < word2.length()) {
            if (isWord1) {
                chars[k] = word1.charAt(i);
                k++;
                i++;
                isWord1 = false;
            } else {
                chars[k] = word2.charAt(j);
                k++;
                j++;
                isWord1 = true;
            }
        }

        while (i < word1.length()) {
            chars[k] = word1.charAt(i);
            k++;
            i++;
        }

        while (j < word2.length()) {
            chars[k] = word2.charAt(j);
            k++;
            j++;
        }

        return new String(chars);
    }
}
