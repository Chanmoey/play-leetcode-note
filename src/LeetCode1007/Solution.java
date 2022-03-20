package LeetCode1007;

/**
 * @author Chanmoey
 * @date 2022年03月20日
 */
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {

            int top = 0;
            int bottom = 0;

            for (int j = 0; j < n; j++) {
                if (tops[j] != i && bottoms[j] != i) {
                    top = -1;
                    break;
                }

                if (tops[j] == i) {
                    top++;
                }

                if (bottoms[j] == i) {
                    bottom++;
                }
            }

            if (top > -1) {
                res = Math.min(n - top, Math.min(n - bottom, res));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
