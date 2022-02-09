package LeetCode415;

import java.math.BigDecimal;

/**
 *
 * 直接使用BigDecimal
 *
 * @author Chanmoey
 * @date 2022年02月09日
 */
class Solution {
    public String addStrings(String num1, String num2) {
        BigDecimal first = new BigDecimal(num1);
        BigDecimal second = new BigDecimal(num2);
        return first.add(second).toString();
    }
}
