package LeetCode557;

/**
 * @author Chanmoey
 * @date 2022年09月22日
 */
class Solution2 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j = i + 1; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                sb.append(reverse(s.substring(i, j))).append(' ');
                i = j + 1;
            } else if (j == s.length() - 1) {
                sb.append(reverse(s.substring(i)));
                break;
            }
        }


        return sb.toString();
    }

    private String reverse(String word) {
        char[] chars = word.toCharArray();
        int i = 0;
        int j = word.length() - 1;
        char temp;
        while (i < j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new String(chars);
    }
}
