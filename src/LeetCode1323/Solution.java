package LeetCode1323;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年11月07日
 */
class Solution {
    public int maximum69Number(int num) {
        int[] digit = new int[5];
        Arrays.fill(digit, -1);
        int idx = 0;
        while (num != 0) {
            digit[idx++] = num % 10;
            num /= 10;
        }

        idx = 4;
        while (digit[idx] == -1) {
            idx--;
        }

        int chance = 1;
        int max = 0;
        for (; idx >= 0; idx--) {
            if (chance == 1) {
                if (digit[idx] == 6) {
                    max = max * 10 + 9;
                    chance = 0;
                } else {
                    max = max * 10 + digit[idx];
                }
            } else {
                max = max * 10 + digit[idx];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximum69Number(9669);
    }
}
