package LeetCode6;

class Solution {
    public String convert(String s, int numRows) {
        int col = s.length() / numRows;

        char[][] chars = new char[numRows][col];
        boolean down = true;

        //  行         列
        int rIdx = 0, cIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (down) {
                chars[rIdx][rIdx] = s.charAt(i);
                if (rIdx == numRows - 1 && down) {
                    down = false;
                }
                rIdx ++;
            } else {
                chars[rIdx][cIdx++] = s.charAt(i);
                if (rIdx == 0) {
                    down = true;
                }
                rIdx --;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if (chars[i][j] != ' ') {
                    sb.append(chars[i][j]);
                }
            }
        }

        return sb.toString();
    }
}
