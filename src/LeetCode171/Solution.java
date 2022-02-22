package LeetCode171;

/**
 * @author Chanmoey
 * @date 2022年02月22日
 */
class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;

        for (char c : columnTitle.toCharArray()) {
            res = res * 26 + (c - 'A') + 1;
        }

        return res;
    }
}
