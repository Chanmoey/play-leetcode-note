package LeetCode149;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*
* 没有处理浮点误差，但是也能通过。？？？
* */
class Solution {
    public int maxPoints(int[][] points) {

        if (points.length <= 1){
            return points.length;
        }

        int res = 0;
        for (int[] i : points) {
            Map<Double, Integer> recode = new HashMap<>();
            for (int[] j : points) {
                if (j != i) {
                    Double tan = tan(i, j);
                    recode.put(tan, recode.getOrDefault(tan, 1) + 1);
                }
            }
            Integer[] number = recode.values().toArray(new Integer[0]);
            Arrays.sort(number, Collections.reverseOrder());
            if (number.length > 0 && number[0] > res){
                res = number[0];
            }
        }

        return res;
    }

    private Double tan(int[] x, int[] y) {
//        return (y[1] * 1.0 - x[1] * 1.0) / (y[0] * 1.0 - x[0] * 1.0);
        return 1.0 * (y[1] - x[1]) / (y[0] - x[0]);
    }
}
