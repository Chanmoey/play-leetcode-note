package LeetCode977;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年01月07日
 */
class Solution {
    public int[] sortedSquares(int[] nums) {

        List<int[]> list = this.splitAndSortedBySquares(nums);
        return this.merge(list);

    }

    private int[] merge(List<int[]> list) {
        int[] first = list.get(0);
        if (first.length == 0) {
            return list.get(1);
        }

        int[] second = list.get(1);
        int i = 0, j = 0, index = 0;
        int[] arr = new int[first.length + second.length];
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                arr[index++] = first[i++];
            } else {
                arr[index++] = second[j++];
            }
        }

        while (i < first.length) {
            arr[index++] = first[i++];
        }

        while (j < second.length) {
            arr[index++] = second[j++];
        }

        return arr;

    }

    private List<int[]> splitAndSortedBySquares(int[] nums) {

        List<int[]> list = new ArrayList<>();

        int i = -1;
        while (i < nums.length - 1 && nums[i + 1] < 0) {
            i++;
        }

        if (i == -1) {
            list.add(new int[]{});
            int[] second = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                second[j] = nums[j] * nums[j];
            }
            list.add(second);
            return list;
        }

        if (i == nums.length - 1) {
            int[] first = new int[nums.length];
            for (int j = 0; j < nums.length; j ++) {
                first[nums.length - 1 - j] = nums[j] * nums[j];
            }
            list.add(first);
            list.add(new int[]{});
            return list;
        }

        int[] first = new int[i + 1];
        for (int j = 0; j <= i; j++) {
            first[first.length - 1 - j] = nums[j] * nums[j];
        }
        list.add(first);

        int[] second = new int[nums.length - 1 - i];
        for (int j = i + 1; j < nums.length; j++) {
            second[j - 1 - i] = nums[j] * nums[j];
        }
        list.add(second);
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortedSquares(new int[]{-1});
    }
}
