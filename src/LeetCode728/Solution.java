package LeetCode728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年10月09日
 */
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (divide(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean divide(int number) {
        int item = number;

        while (item > 0) {
            int digit = item % 10;
            item /= 10;

            if (digit == 0) {
                return false;
            }

            if (number % digit != 0) {
                return false;
            }
        }

        return true;
    }
}
