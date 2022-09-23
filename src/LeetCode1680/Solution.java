package LeetCode1680;

import java.math.BigDecimal;

/**
 * Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年09月23日
 */
class Solution {

    private static final BigDecimal MOD = new BigDecimal("1000000007");

    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }

        BigDecimal bigDecimal = new BigDecimal("0");
        String bin = sb.toString();
        BigDecimal weight = new BigDecimal("1");
        BigDecimal two = new BigDecimal("2");
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                bigDecimal = bigDecimal.add(weight);
            }
            weight = weight.multiply(two);
        }
        return bigDecimal.divideAndRemainder(MOD)[1].intValue();
    }
}
