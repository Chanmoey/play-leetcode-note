package LeetCode217;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        if (nums.length == 1) {
            return false;
        }

        Set<Integer> record = new HashSet<>();
        for (int i : nums) {
            if (record.contains(i)){
                return true;
            } else {
                record.add(i);
            }
        }

        return false;
    }
}
