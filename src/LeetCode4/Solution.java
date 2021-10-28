package LeetCode4;

import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] newNums = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                newNums[k++] = nums1[i++];
            } else {
                newNums[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            newNums[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            newNums[k++] = nums2[j++];
        }

        System.out.println(Arrays.toString(newNums) + k);

        if ((k & 1) == 1) {
            return newNums[k / 2];
        } else {
            return (newNums[k / 2] + newNums[k / 2 - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}
