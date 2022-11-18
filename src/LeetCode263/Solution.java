package LeetCode263;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
class Solution {
    public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        // 这个循环之后，n将不会被2/3/5整除，如果此时n不为1，则说明起码n还能被n整除。就不是ugly。
        for (int factor : new int[]{2, 3, 5}) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        return n == 1;
    }
}
