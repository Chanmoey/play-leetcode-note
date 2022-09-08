package LeetCode1816;

class Solution {
    public String truncateSentence(String s, int k) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count ++;
                if (count == k) {
                    index = i;
                    break;
                }
            }
        }

        return index == -1 ? s : s.substring(0, index);
    }
}
