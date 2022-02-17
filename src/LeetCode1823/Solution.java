package LeetCode1823;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年02月17日
 */
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int start = 0;
        while (list.size() != 1) {
            start = (start + k - 1) % list.size();
            list.remove(start);
        }

        return list.get(0);
    }
}
