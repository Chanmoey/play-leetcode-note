package LeetCode461;

/**
 * @author Chanmory
 * @date 2021年11月19日 18:56
 * @description
 */
class Solution {
    public int hammingDistance(int x, int y) {

        int z = x ^ y;

        int number = 0;

        while (z > 0) {
            if ((z & 1) == 1) {
                number ++;
            }
            z = z >> 1;
        }

        return number;
    }
}