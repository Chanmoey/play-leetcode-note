package LeetCode989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2023年02月15日
 */
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;
        while (i >= 0) {
            int sum = num[i] + (k % 10) + carry;
            res.add(sum % 10);
            carry = sum / 10;
            k /= 10;
            i--;
        }

        while (k != 0) {
            int sum = (k % 10) + carry;
            res.add(sum % 10);
            carry = sum / 10;
            k /= 10;
        }

        if (carry != 0) {
            res.add(carry);
        }

        Collections.reverse(res);
        return res;
    }
}
