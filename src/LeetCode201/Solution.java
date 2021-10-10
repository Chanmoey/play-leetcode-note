package LeetCode201;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int cur = 0;

        for (int i = 30; i >= 0; i--) {
            if (left < cur + (1 << i) && cur + (1 << i) <= right) {
                break;
            } else if (left >= cur + (1 << i)) {
                cur += (1 << i);
            }
        }

        return cur;
    }
}
