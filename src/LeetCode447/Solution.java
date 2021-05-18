package LeetCode447;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i++) {

            Map<Integer, Integer> recode = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    Integer distance = this.dis(points[i], points[j]);
                    recode.put(distance, recode.getOrDefault(distance, 0) + 1);
                }
            }

            for (Integer v: recode.values()){
                res += v * (v - 1);
            }
        }

        return res;
    }

    private Integer dis(int[] i, int[] j){
        return (i[0] - j[0]) * (i[0] - j[0]) +
                (i[1] - j[1]) * (i[1] - j[1]);
    }
}