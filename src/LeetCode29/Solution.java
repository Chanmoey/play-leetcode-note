package LeetCode29;

/**
 * 992 / 992 test cases passed, but took too long.
 *
 * @author Chanmoey
 * @date 2022年05月30日
 */
class Solution {

    private static final long MAX_VALUE = 2147483647L;
    private static final long MIN_VALUE = 2147483648L;

    public int divide(int dividend, int divisor) {
        long newDividend = dividend;
        long newDivisor = divisor;

        long quotient = 0;
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        newDividend = Math.abs(newDividend);
        newDivisor = Math.abs(newDivisor);

        if (divisor == 1) {
            quotient = newDividend;
            newDivisor = Long.MAX_VALUE;
        }

        while (newDividend >= newDivisor) {
            quotient++;
            newDividend -= newDivisor;
        }

        if (negative) {
            if (quotient >= MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return -(int) quotient;
            }
        } else {
            if (quotient >= MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) quotient;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648, -1));
    }
}
