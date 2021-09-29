package LeetCode383;

import java.util.Arrays;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ran = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();

        Arrays.sort(ran);
        Arrays.sort(maga);

        int j = 0;
        for (char c : maga) {
            if (j < ran.length) {
                if (c == ran[j]) {
                    j ++;
                }
            } else {
                return true;
            }
        }

        return false;
    }
}
