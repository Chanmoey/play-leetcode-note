package LeetCode448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmory
 * @date 2021年11月18日 9:13
 * @description LeetCode448题
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        int[] map = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = i + 1;
        }

        for (int num : nums) {
            int index = this.getMapIndex(num, n);
            map[index] = 0;
        }

        List<Integer> res = new ArrayList<>();
        for (int m : map) {
            if (m != 0) {
                res.add(m);
            }
        }

        return res;
    }

    private int getMapIndex(int num, int n) {
        int index = num % n - 1;
        return index == -1 ? n - 1 : index;
    }
}
