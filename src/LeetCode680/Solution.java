package LeetCode680;

/**
 * @author Chanmoey
 * @date 2022年04月02日
 */
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                int ii = i + 1;
                int jj = j;
                while (ii < jj) {
                    if (s.charAt(ii) != s.charAt(jj)) {
                        break;
                    }
                    ii++;
                    jj--;
                }
                if (ii >= jj) {
                    return true;
                }

                ii = i;
                jj = j - 1;

                while (ii < jj) {
                    if (s.charAt(ii) != s.charAt(jj)) {
                        break;
                    }
                    ii++;
                    jj--;
                }

                return ii >= jj;
            }
            i++;
            j--;
        }

        return true;
    }
}
