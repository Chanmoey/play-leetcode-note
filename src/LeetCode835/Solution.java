package LeetCode835;

/**
 * @author Chanmoey
 * @date 2022年10月27日
 */
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        for (int row = -img1.length; row < img1.length; row++) {
            for (int col = -img1[0].length; col < img1[0].length; col++) {
                res = Math.max(res, overlap(img1, img2, row, col));
            }
        }

        return res;
    }

    private int overlap(int[][] img1, int[][] img2, int rowOffset, int colOffset) {
        int res = 0;
        for (int row = 0; row < img1.length; row++) {
            for (int col = 0; col < img1[0].length; col++) {
                if ((row + rowOffset < 0 || row + rowOffset >= img1.length)
                        || (col + colOffset < 0 || col + colOffset >= img1.length)) {
                    continue;
                }
                if (img1[row][col] == 1 && img2[row + rowOffset][col + colOffset] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
