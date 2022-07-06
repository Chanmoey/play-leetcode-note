package LeetCode509;

/**
 * 递归
 *
 * @author Chanmoey
 * @date 2022年07月06日
 */
public class Solution1 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
