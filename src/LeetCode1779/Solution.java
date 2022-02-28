package LeetCode1779;

/**
 * @author Chanmoey
 * @date 2022年02月28日
 */
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minManhattan = Integer.MAX_VALUE;
        int distance;
        int index = -1;
        int[] point;

        for (int i = 0; i < points.length; i++) {
            point = points[i];
            if (point[0] == x || point[1] == y) {
                distance = this.getManhattanDistance(point, x, y);
                if (distance < minManhattan) {
                    minManhattan = distance;
                    index = i;
                }
            }
        }

        return index;
    }

    private int getManhattanDistance(int[] point, int x, int y) {
        return Math.abs(x - point[0]) + Math.abs(y - point[1]);
    }
}
