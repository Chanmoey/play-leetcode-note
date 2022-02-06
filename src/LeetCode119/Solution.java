package LeetCode119;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年02月06日
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>(rowIndex + 1);
        triangle.add(Arrays.asList(1));
        triangle.add(Arrays.asList(1, 1));
        /**
         * 1
         * 1 1
         * 1 2 1
         * 1 3 3 1
         * 1 4 6 4 1
         * 1 5 10 10 5 1
         * 1 6 15 20 15 6 1
         */
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            row.add(1);
            triangle.add(row);
        }

        return triangle.get(rowIndex);
    }
}
