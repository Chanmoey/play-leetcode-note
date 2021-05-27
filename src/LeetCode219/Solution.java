package LeetCode219;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            if (record.contains(nums[i])){
                return true;
            } else {
                record.add(nums[i]);
            }

            if (record.size() == k + 1){
                record.remove(nums[i - k]);
            }
        }

        return false;
    }
}
