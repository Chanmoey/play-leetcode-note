package LeetCode645;

/**
 * Use Map
 */
class Solution1 {
    public int[] findErrorNums(int[] nums) {
        int[] map = new int[nums.length + 1];
        int[] res = new int[2];

        for (int num : nums) {
            map[num]++;
        }

        for (int i = 1; i < map.length; i++) {
            if (map[i] >= 2) {
                res[0] = i;
            }

            if (map[i] == 0) {
                res[1] = i;
            }
        }

        return res;
    }
}
