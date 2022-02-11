package LeetCode43;

/**
 *
 * 错误的解法，根据加法改变而来，没有考虑乘法和加法的差异。
 *
 * @author Chanmoey
 * @date 2022年02月11日
 */
class Solution1 {

    private static final String ZERO = "0";
    private static final String ONE = "1";

    public String multiply(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        if (i == -1 || j == -1 || ZERO.equals(num1) || ZERO.equals(num2)) {
            return String.valueOf(0);
        }

        if (ONE.equals(num1)) {
            return num2;
        }

        if (ONE.equals(num2)) {
            return num1;
        }

        int remainder;
        int carry = 0;
        int temp;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            temp = (num1.charAt(i--) - '0') * (num2.charAt(j--) - '0') + carry;
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
