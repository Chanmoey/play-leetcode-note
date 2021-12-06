package LeetCode1217;

/**
 * @author Chanmoey
 * @date 2021年12月06日 8:19
 * @description 奇数和偶数总能通过移动两位（不消耗）到达相邻的位置，因此只需要将数量最少的移动到数量最多的上就行。
 */
class Solution {
    public int minCostToMoveChips(int[] position) {

        int odd = 0;
        for (int p : position) {
            if ((p & 1) == 1) {
                odd ++;
            }
        }

        return Math.min(odd, position.length - odd);
    }
}
