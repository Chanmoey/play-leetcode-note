package LeetCode217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i ++) {
//            if (nums[i] == nums[i + 1]){
//                return true;
//            }
            // 测试函数的调用是否会影响性能
            if (isEqual(nums[i], nums[i + 1])) {
                return true;
            }
        }

        return false;
    }

    private boolean isEqual(int one, int two) {
        return one == two;
    }
}
