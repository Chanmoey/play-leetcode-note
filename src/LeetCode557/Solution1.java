package LeetCode557;

class Solution1 {
    public String reverseWords(String s) {

        String[] stringList = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stringList.length; i ++) {
            sb.append(new StringBuilder(stringList[i]).reverse());
            if (i != stringList.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}

