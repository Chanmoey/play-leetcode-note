package LeetCode1281;

/**
 * @author Chanmoey
 * @date 2022年02月27日
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int remainder;
        while (n != 0) {
            remainder = n % 10;
            product *= remainder;
            sum += remainder;
            n /= 10;
        }

        return product - sum;
    }
}
