package LeetCode1636;

class Solution {
    public int[] frequencySort(int[] nums) {

        if (nums.length == 1) {
            return nums;
        }

        int[] freq = new int[201];
        int[] res = new int[nums.length];

        // 统计频率
        for (int num : nums) {
            freq[num + 100]++;
        }

        int index = res.length - 1;
        int max = 0;
        int maxIndex = -1;
        while (index >= 0) {

            for (int j = 0; j < freq.length; j ++) {
                if (freq[j] > max) {
                    max = freq[j];
                    maxIndex = j;
                }
            }

            for (int k = 0; k < max; k++) {
                res[index--] = maxIndex - 100;
            }

            max = 0;
            freq[maxIndex] = 0;
        }

        return res;
    }
}
