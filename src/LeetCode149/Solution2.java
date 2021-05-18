package LeetCode149;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 处理浮点误差，通过Sting存储分数的最简形式
 * */

public class Solution2 {
    public int maxPoints(int[][] points) {

        if (points.length <= 1) {
            return points.length;
        }

        int res = 1;
        for (int[] ints : points) {

            Map<String, Integer> record = new HashMap<>();
            int samePoint = 0;
            for (int[] point : points) {

                if (ints[0] == point[0] && ints[1] == point[1]) {
                    samePoint++;
                } else {
                    record.put(slope(point, ints),
                            record.getOrDefault(slope(point, ints), 0) + 1);
                }
            }

            res = Math.max(res, samePoint);
            Integer[] number = record.values().toArray(new Integer[0]);
            Arrays.sort(number, Collections.reverseOrder());
            res = Math.max(res, number[0] + samePoint);
        }

        return res;
    }

    private String slope(int[] pa, int[] pb) {
        int dy = pa[1] - pb[1];
        int dx = pa[0] - pb[0];
        if (dx == 0) {
            return 1 + "/" + 0;
        }
        if (dy == 0){
            return 0 + "/" + 1;
        }

        int g = this.gcd(Math.abs(dy), Math.abs(dx));
        dy /= g;
        dx /= g;

        if (dx < 0) {
            dy = -dy;
            dx = -dx;
        }

        return dy + "/" + dx;

    }

    private int gcd(int a, int b){
        if (a < b){
            int t = a;
            a = b;
            b = t;
        }
        if (a % b == 0) {
            return b;
        }

        return this.gcd(b, a%b);
    }
}
