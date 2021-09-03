package LeetCode69;

class Solution {
    public int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }

        int st = 1, end = x / 2 + 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
