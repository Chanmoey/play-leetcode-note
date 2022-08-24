package LeetCode326;

/**
 * @author Chanmoey
 * @date 2022年08月24日
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            if (n % 3 != 0) {
                return false;
            }

            return isPowerOfThree(n / 3);
        }
    }
}
