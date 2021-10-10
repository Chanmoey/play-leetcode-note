package LeetCode190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 1; i <= 32; i++) {
            res |= (n & 1) << (32 - i);
            n >>= 1;
        }

        return res;
    }
}
