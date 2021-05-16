package LeetCode75;

class Solution {
    /*public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }
        int j = 0;
        for (; j < zero; j++) {
            nums[j] = 0;
        }
        for (; j < zero + one; j++) {
            nums[j] = 1;
        }
        for (; j < zero + one + two; j++) {
            nums[j] = 2;
        }
    }*/

    /*public void sortColors(int[] nums) {
        int[] counts = {0, 0, 0};

        for (int num : nums) {
            counts[num] ++;
        }

        int index = 0;
        int loop = 0;
        for(int i = 0; i < 3; i++){

            loop += counts[i];

            for(; index < loop; index++){
                nums[index] = i;
            }
        }
    }*/

    public void sortColors(int[] nums) {
        int zero = -1; // nums[0...zero] == 0
        int two = nums.length; // nums[two...length-1] == 2
        int temp;

        int i = 0;
        while (i < two) { // nums[zero+1...i) == 1

            if (nums[i] == 0) {
                zero++;
                temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            } else if (nums[i] == 2) {
                two --;
                temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 0};
        s.sortColors(nums);

        for (int num : nums) {
            System.out.print(num);
        }
    }
}
