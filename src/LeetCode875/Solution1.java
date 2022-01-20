package LeetCode875;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年01月20日
 */
class Solution1 {

    public int minEatingSpeed(int[] piles, int h) {
        assert piles.length > 0;
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (this.eatFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean eatFinish(int[] piles, int k, int h) {
        int t = 0;
        for (int pile : piles) {
            t += pile / k + (pile % k == 0 ? 0 : 1);
        }

        return t <= h;
    }
}
