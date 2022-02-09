package LeetCode415;

import java.math.BigDecimal;

/**
 * @author Chanmoey
 * @date 2022年02月09日
 */
class Solution1 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int remainder;
        int carry = 0;
        int temp;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            temp = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0') + carry;
            remainder = temp % 10;
            carry = temp / 10;
            sb.append(remainder);
        }

        while (i >= 0) {
            temp = (num1.charAt(i--) - '0') + carry;
            remainder = temp % 10;
            carry = temp / 10;
            sb.append(remainder);
        }

        while (j >= 0) {
            temp = (num2.charAt(j--) - '0') + carry;
            remainder = temp % 10;
            carry = temp / 10;
            sb.append(remainder);
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
