package LeetCode42;

/**
 * @author Chanmoey
 * @date 2022年09月18日
 */
class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int sum = 0;
        int lMax = 0;
        int rMax = 0;

        while (l <= r) {
            lMax = Math.max(height[l], lMax);
            rMax = Math.max(height[r], rMax);

            if (lMax < rMax) {
                sum += lMax - height[l++];
            } else {
                sum += rMax - height[r--];
            }
        }

        return sum;
    }
}
