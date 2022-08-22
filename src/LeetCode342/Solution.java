package LeetCode342;

/**
 * @author Chanmoey
 * @date 2022年08月22日
 */
class Solution {
    public boolean isPowerOfFour(int n) {
        while (n >= 4) {
            if (n % 4 != 0) {
                return false;
            }
            n >>= 2;
        }

        return n == 1;
    }
}
