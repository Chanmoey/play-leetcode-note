package LeetCode29;

/**
 * @author Chanmoey
 * @date 2022年05月30日
 */
class Solution1 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long quotient = 0;
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long newDividend = Math.abs((long) dividend);
        long newDivisor = Math.abs((long) divisor);

        while (newDividend >= newDivisor) {
            long temp = newDivisor;
            long m = 1;
            while ((temp * 2) <= newDividend) {
                temp *= 2;
                m *= 2;
            }
            newDividend -= temp;
            quotient += m;
        }

        return (int) (negative ? -quotient : quotient);
    }
}
