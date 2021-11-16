package LeetCode668;

/**
 * @author Chanmory
 * @date 2021年11月16日 9:29
 * @description 参考了讨论区的解答。
 */
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (!enough(m, n, k, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    private boolean enough(int m, int n, int k, int e) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(e / i, n);
        }

        return count >= k;
    }
}
