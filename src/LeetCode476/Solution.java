package LeetCode476;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2021年12月27日
 */
class Solution {
    public int findComplement(int num) {
        List<Integer> bin = new ArrayList<>();
        while (num != 0) {
            bin.add(num & 1);
            num >>= 1;
        }

        Collections.reverse(bin);

        int res = 0;
        for (Integer e : bin) {
            res <<= 1;

            // 如果原来该位是0，则变成1。
            if (e == 0) {
                res += 1;
            }
        }

        return res;
    }
}
