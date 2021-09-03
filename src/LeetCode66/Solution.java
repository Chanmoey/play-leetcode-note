package LeetCode66;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry != 0) {
                int add = carry + digits[i];
                digits[i] = add % 10;
                carry = add / 10;
            } else {
                break;
            }
        }

        if (carry != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            System.arraycopy(digits, 0, res, 1, res.length - 1);
            return res;
        }

        return digits;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] digits = {9};
        int[] res = s.plusOne(digits);
        System.out.println(Arrays.toString(res));
    }
}
