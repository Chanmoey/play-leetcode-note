package LeetCode34;

/**
 * @author Chanmoey
 * @date 2022年07月25日
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        if (nums.length == 0) {
            return res;
        }

        int i = 0;
        int j = nums.length - 1;
        boolean stopI = false;
        boolean stopJ = false;
        while (i <= j) {
            if (!stopI) {
                if (nums[i] == target) {
                    res[0] = i;
                    stopI = true;
                } else {
                    i++;
                }
            }

            if (!stopJ) {
                if (nums[j] == target) {
                    res[1] = j;
                    stopJ = true;
                } else {
                    j--;
                }
            }

            if (stopI && stopJ) {
                break;
            }
        }

        return res;
    }
}
