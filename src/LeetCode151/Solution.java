package LeetCode151;

class Solution {
    public String reverseWords(String s) {

        if (s.length() == 1) {
            return s;
        }

        boolean start = false;
        String[] words = new String[10000];
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                if (start) {
                    words[index++] = sb.toString();
                    start = false;
                    sb.setLength(0);
                }
            } else {
                sb.append(s.charAt(i));
                if (!start) {
                    start = true;
                }
            }
        }

        if (sb.length() > 0) {
            words[index++] = sb.toString();
        }

        sb.setLength(0);
        for (int j = index - 1; j >= 0; j--) {
            sb.append(words[j]);
            if (j != 0) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
