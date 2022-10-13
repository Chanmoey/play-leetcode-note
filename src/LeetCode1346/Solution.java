package LeetCode1346;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年10月13日
 */
class Solution {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>(arr.length * 2);

        for (int j : arr) {
            if (j % 2 == 0) {
                if (set.contains(j * 2) || set.contains(j / 2)) {
                    return true;
                }
            } else {
                if (set.contains(j * 2)) {
                    return true;
                }
            }
            set.add(j);
        }

        return false;
    }
}
