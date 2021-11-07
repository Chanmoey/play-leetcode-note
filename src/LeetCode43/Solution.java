package LeetCode43;

class Solution {

    private static final String ZERO = "0";
    private static final String ONE = "1";

    public String multiply(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();

        if (l1 == 0 || l2 == 0 || ZERO.equals(num1) || ZERO.equals(num2)) {
            return String.valueOf(0);
        }

        if (ONE.equals(num1)) {
            return num2;
        }

        if (ONE.equals(num2)) {
            return num1;
        }

        int[] result = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int product = this.charToInt(num1.charAt(i)) *
                        this.charToInt(num2.charAt(j));
                product += result[i + j + 1];
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if (sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }

        return sb.toString();
    }

    private int charToInt(char c) {
        return c - '0';
    }
}
