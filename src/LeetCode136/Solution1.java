package LeetCode136;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
