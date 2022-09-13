package LeetCode393;

/**
 * @author Chanmoey
 * @date 2022年09月13日
 */
class Solution {

    private static final int MASK = 0b1111_1111;
    private static final int ONE_MASK = 0b1100_0000;
    private static final int ONE = 0b1000_0000;
    private static final int TWO = 0b1100_0000;
    private static final int TWO_MASK = 0b1110_0000;
    private static final int THREE = 0b1110_0000;
    private static final int THREE_MASK = 0b1111_0000;
    private static final int FOUR = 0b1111_0000;
    private static final int FOUR_MASK = 0b1111_1000;

    public boolean validUtf8(int[] data) {
        int idx = 0;
        int cnt = 0;
        while (idx < data.length) {
            int num = data[idx];
            if ((num & MASK) < ONE) {
                if (cnt != 0) {
                    return false;
                }
                idx++;
            } else if ((num & FOUR_MASK) == FOUR) {
                if (cnt != 0) {
                    return false;
                }
                cnt = 3;
                idx++;
            } else if ((num & THREE_MASK) == THREE) {
                if (cnt != 0) {
                    return false;
                }
                cnt = 2;
                idx++;
            } else if ((num & TWO_MASK) == TWO) {
                if (cnt != 0) {
                    return false;
                }
                cnt = 1;
                idx++;
            } else if ((num & ONE_MASK) == ONE) {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
                idx++;
            } else {
                return false;
            }
        }
        return cnt == 0;
    }
}
