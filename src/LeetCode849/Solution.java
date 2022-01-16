package LeetCode849;

/**
 * @author Chanmoey
 * @date 2022年01月16日
 */
class Solution {
    public int maxDistToClosest(int[] seats) {
        int leftCount = 0, rightCount = 0, i = 0, j = seats.length - 1;

        while (i != j && seats[i] == 0) {
            leftCount++;
            i++;
        }

        while (i != j && seats[j] == 0) {
            rightCount++;
            j--;
        }

        int count = 0, maxCount = Math.max(leftCount, rightCount);
        int max = 0;
        while (i != j) {
            if (seats[i] == 1) {
                count = 0;
            } else {
                count ++;
                max = Math.max(max, count);
            }
            i++;
        }
        return Math.max((max + 1) / 2, maxCount);
    }
}
