package LeetCode223;

/**
 * @author Chanmoey
 * @date 2022年11月17日
 */
class Solution {

    /**
     * (ax1, ay1) 左下
     * (ax2, ay2) 右上
     * --------------
     * (bx1, by1) 左下
     * (bx2, by2) 右上
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int length1 = Math.abs(ax1 - ax2);
        int width1 = Math.abs(ay1 - ay2);
        int area1 = length1 * width1;

        int length2 = Math.abs(bx1 - bx2);
        int width2 = Math.abs(by1 - by2);
        int area2 = length2 * width2;

        // a------------b
        //       c------------d
        // overlap = len(a, b) + len(c, d) - len(a, d)
        int overlapX = (ax2 - ax1) + (bx2 - bx1) - (Math.max(ax2, bx2) - Math.min(ax1, bx1));
        int overlapY = (ay2 - ay1) + (by2 - by1) - (Math.max(ay2, by2) - Math.min(ay1, by1));
        int overlapArea = 0;
        if (overlapX > 0 && overlapY > 0) {
            overlapArea = overlapX * overlapY;
        }

        return area1 + area2 - overlapArea;
    }
}
