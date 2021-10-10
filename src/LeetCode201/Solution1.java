package LeetCode201;

class Solution1 {
    public int rangeBitwiseAnd(int left, int right) {

        if (left == 0) {
            return 0;
        }

        int index = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            index ++;
        }

        return left << index;
    }
}
