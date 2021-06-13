package LeetCode58;

class Solution1 {
    public int lengthOfLastWord(String s) {
        int l = -1, r = -1;
        boolean findR = false;
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                if (!findR) {
                    findR = true;
                    r = i;
                }
            } else {
                if (findR) {
                    l = i;
                    break;
                }
            }
        }

        if (r == -1) {
            return 0;
        }
        if (l == -1) {
            return r + 1;
        }

        return r - l;
    }
}
