package LeetCode168;

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber -= 1;
            char ch = (char) ('A' + columnNumber % 26);
            sb.append(ch);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
