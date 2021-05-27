package LeetCode14;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length < 1) {
            return "";
        }

        if (strs.length == 1){
            return strs[0];
        }


        for (String str : strs) {
            if (str.isEmpty()) {
                return "";
            }
        }

        char[] pre = new char[200];
        String str0 = strs[0];
        String str1 = strs[1];
        int length = 0;
        for (int i = 0; i < str0.length() && i < str1.length(); i++) {
            if (str0.charAt(i) == str1.charAt(i)) {
                pre[length] = str0.charAt(i);
                length ++;
            } else {
                break;
            }
        }

        if (length <= 0){
            return "";
        }

        for (int i = 2; i < strs.length; i ++) {

            if (strs[i].length() < length){
                length = strs[i].length();
            }

            if (length <= 0){
                return "";
            }

            for (int j = 0; j < length && j < strs[i].length(); j ++) {
                if (pre[j] != strs[i].charAt(j)){
                    length = j;
                }
            }
        }

        if (length <= 0){
            return "";
        }

        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < length; i ++) {
            stringBuffer.append(pre[i]);
        }

        return stringBuffer.toString();
    }
}
