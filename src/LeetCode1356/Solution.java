package LeetCode1356;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Chanmoey
 * @date 2022年03月08日
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(nums, Comparator.comparingInt(Integer::bitCount)
                .thenComparingInt(n -> n));

        return Arrays.stream(nums)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
