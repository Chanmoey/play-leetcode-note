package LeetCode231;

/**
 * @author Chanmoey
 * @date 2021年12月21日 8:52
 * @description
 */
class Solution {

    /**
     * 16 ms
     *
     * @param n n
     * @return result
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        int i = 1;
        do {
            i <<= 1;
            System.out.println(i);
            if (i == n) {
                return true;
            }
        } while (i <= n && i > 0);

        return false;
    }

    /**
     * better
     *
     * @param n n
     * @return result
     */
    public boolean isPowerOfTwo0(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfTwo(1073741825));
    }
}
