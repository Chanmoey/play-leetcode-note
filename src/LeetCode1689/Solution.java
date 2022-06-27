package LeetCode1689;

/**
 * @author Chanmoey
 * @date 2022年06月28日
 */
class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            res = Math.max(res, n.charAt(i) - '0');
        }
        return res;
    }
}