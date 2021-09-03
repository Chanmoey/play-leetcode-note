package LeetCode67;

import java.util.Arrays;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int carry = 0, i = 0;
        int al = a.length() - 1;
        int bl = b.length() - 1;

        while (i <= al || i <= bl || carry != 0) {
            int x = 0;
            if (i <= al && a.charAt(al - i) == '1') {
                x = 1;
            }

            int y = 0;
            if (i <= bl && b.charAt(bl - i) == '1') {
                y = 1;
            }

            result.insert(0, ((x + y + carry) % 2));
            carry = (x + y + carry) / 2;
            i++;
        }
        return result.toString();
    }

    public int[] strToInts(String s) {
        int[] ints = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ints[i] = s.charAt(i) - '0';
        }
        return ints;
    }

    public String intsToStr(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for (int i : ints) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1010";
        int[] i = {1, 0, 1, 0};
        System.out.println(Arrays.toString(solution.strToInts(s)));
        System.out.println(solution.intsToStr(i));
    }
}
