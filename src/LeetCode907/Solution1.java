package LeetCode907;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chanmoey
 * @date 2022年11月25日
 */
class Solution1 {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;

        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0;

        for (int i = 0; i <= arr.length; i++) {

            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
                // 如果现在访问的元素比栈顶小，则栈顶出栈，现在访问的元素是mid的下一个最小值。
                int mid = stack.pop();

                // 如果现在栈不为空，则现在的栈顶是mid的前一个最小值
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                // 计算mid会被统计的次数
                long count = (long) (mid - leftBoundary) * (i - mid) % mod;

                res += (count * arr[mid]) % mod;
                res %= mod;
            }
            stack.push(i);
        }

        return (int) (res);
    }
}