package LeetCode228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年02月28日
 */
class Solution {

    private static final String ARROW = "->";

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] != 1) {
                    j = j - 1;
                    if (j - i > 0) {
                        res.add(nums[i] + ARROW + nums[j]);
                    } else {
                        res.add(String.valueOf(nums[i]));
                    }

                    i = j;
                    break;
                }
            }
            if (j >= nums.length) {
                if (i >= nums.length - 1) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    res.add(nums[i] + ARROW + nums[nums.length - 1]);
                }
                break;
            }
        }

        return res;
    }
}
