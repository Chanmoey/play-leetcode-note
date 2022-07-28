package LeetCode242;

/**
 * @author Chanmoey
 * @date 2022年07月28日
 */
class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = new char[26];
        char[] tc = new char[26];

        for (int i = 0; i < s.length(); i++) {
            sc[s.charAt(i) - 'a'] ++;
            tc[t.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != tc[i]) {
                return false;
            }
        }

        return true;
    }
}
