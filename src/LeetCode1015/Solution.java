package LeetCode1015;

/**
 * @author Chanmoey
 * @date 2021年12月30日
 */
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k == 1) {
            return 1;
        }

        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int length = 1, n = 1;
        while (n != 0) {
            n = n * 10 + 1;
            n = n % k;
            length ++;
        }

        return length;
    }
}
