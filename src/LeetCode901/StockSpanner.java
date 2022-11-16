package LeetCode901;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chanmoey
 * @date 2022年11月09日
 */
class StockSpanner {

    Deque<int[]> stack = new ArrayDeque<>();

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }

        stack.push(new int[]{price, ans});
        return ans;
    }
}