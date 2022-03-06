package LeetCode1359;

/**
 * @author Chanmoey
 * @date 2022年03月06日
 */
class Solution {
    public int countOrders(int n) {
        long mod = 1000000007L;
        long res = 1L;
        for (int i = 1; i < n; i++) {
            res = ((2L * i + 1) * (i + 1) * res) % mod;
        }

        return (int) res;
    }
}
