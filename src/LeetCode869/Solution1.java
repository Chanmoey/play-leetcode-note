package LeetCode869;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年08月26日
 */
class Solution1 {
    public boolean reorderedPowerOf2(int n) {
        char[] digit = sort2digit(n);
        for (int i = 0; i < 30; i++) {
            char[] powerOfTwo = sort2digit(1 << i);
            if (Arrays.equals(digit, powerOfTwo)) {
                return true;
            }
        }

        return false;
    }

    private char[] sort2digit(int n) {
        char[] digit = String.valueOf(n).toCharArray();
        Arrays.sort(digit);
        return digit;
    }
}
