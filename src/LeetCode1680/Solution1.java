package LeetCode1680;

/**
 * @author Chanmoey
 * @date 2022年09月23日
 */
class Solution1 {
    public int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long result = 0;
        int binaryDigits = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) binaryDigits++;
            result = ((result << binaryDigits) + i) % modulo;
        }
        return (int) result;
    }
}
