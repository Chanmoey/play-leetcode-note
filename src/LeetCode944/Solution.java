package LeetCode944;

/**
 * @author Chanmoey
 * @date 2022年06月07日
 */
class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int cow = strs[0].length();

        int delete = 0;
        for (int j = 0; j < cow; j++) {
            for (int i = 0; i < row - 1; i++) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    delete ++;
                    break;
                }
            }
        }

        return delete;
    }
}
