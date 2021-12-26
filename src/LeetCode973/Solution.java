package LeetCode973;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2021年12月26日 8:35
 * @description
 */
class Solution {

    private static class Neighbour implements Comparable<Neighbour> {
        int distance;
        int[] coordinate;

        public Neighbour(int distance, int[] coordinate) {
            this.distance = distance;
            this.coordinate = coordinate;
        }

        public int[] getCoordinate() {
            return this.coordinate;
        }

        @Override
        public int compareTo(Neighbour o) {
            return this.distance - o.distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Neighbour[] neighbours = this.getNeighbour(points);
        Arrays.sort(neighbours);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i ++) {
            res[i] = neighbours[i].getCoordinate();
        }

        return res;
    }

    private Neighbour[] getNeighbour(int[][] points) {
        Neighbour[] neighbours = new Neighbour[points.length];
        int distance;
        int index = 0;
        for (int[] point : points) {
            distance = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
            neighbours[index++] = new Neighbour(distance, point);
        }

        return neighbours;
    }
}