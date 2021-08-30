package LeetCode8;

class Solution {

    public int myAtoi(String s) {
        s = s.trim();

        int length = s.length();
        boolean isPositive = true;
        int res = 0;
        int st = 0;

        if (s.startsWith("+")) {
            st = 1;
        }

        if (s.startsWith("-")) {
            isPositive = false;
            st = 1;
        }

        for (int i = st; i < length; i++) {
            int diff = s.charAt(i) - '0';
            if (diff >= 0 && diff <= 9) {
                if ((Integer.MAX_VALUE - diff) / 10 < res) {
                    if (isPositive) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                res = res * 10 + diff;
            } else {
                break;
            }
        }

        if (isPositive) {
            return res;
        }
        return (-1) * res;
    }
}
