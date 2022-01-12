package LeetCode567;

/**
 * @author Chanmoey
 * @date 2022年01月12日
 */
class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length(), m = s2.length();

        if (n > m) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < n; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (check(count1, count2)) {
            return true;
        }

        for (int i = n; i < m; i++) {

            count2[s2.charAt(i - n) - 'a']--;
            count2[s2.charAt(i) - 'a']++;

            if (check(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    private boolean check(int[] count1, int[] count2) {

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }
}
