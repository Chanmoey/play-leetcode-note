package LeetCode8;

public class Solution1 {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index == s.length()) {
            return 0;
        }

        boolean isPositive = true;
        if (s.charAt(index) == '-') {
            isPositive = false;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        int res = 0;
        while (index < s.length()) {
            int diff = s.charAt(index++) - '0';
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
