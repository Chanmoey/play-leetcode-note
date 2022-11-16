package LeetCode504;

/**
 * @author Chanmoey
 * @date 2022年11月16日
 */
class Solution {
    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        return negative ? "-" + sb.reverse() : sb.reverse().toString();
    }
}
