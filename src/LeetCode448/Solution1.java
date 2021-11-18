package LeetCode448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmory
 * @date 2021年11月18日 9:25
 * @description
 */
class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        int[] map = new int[n];

        for (int num : nums) {
            map[num - 1] ++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
