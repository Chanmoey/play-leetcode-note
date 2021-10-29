package LeetCode6;

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int col = s.length();

        char[][] chars = new char[numRows][col];
        boolean down = true;

        for (int i = 0; i < numRows; i ++) {
            for (int j = 0; j < col; j++) {
                chars[i][j] = '*';
            }
        }

        //  行         列
        int rIdx = 0, cIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("rIdx = " + rIdx + ", cIdx = " + cIdx);
            chars[rIdx][cIdx] = s.charAt(i);
            if (down) {
                if (rIdx == numRows - 1 ) {
                    down = false;
                    rIdx--;
                    cIdx++;
                } else {
                    rIdx++;
                }

            } else {
                if (rIdx == 0) {
                    down = true;
                    rIdx ++;
                } else {
                    rIdx--;
                    cIdx++;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if (chars[i][j] != '*') {
                    sb.append(chars[i][j]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.convert("AB", 1);
    }
}
