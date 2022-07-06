package LeetCode509;

/**
 * dp
 *
 * @author Chanmoey
 * @date 2022年07月06日
 */
class Solution {

    public int fib(int n) {
        int[] res = new int[31];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
