package LeetCode93;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        this.findIpAddresses(s, 0, "", 0);

        return this.res;
    }

    // s.length must be greater than zero.
    private boolean isValidInteger(String s) {

        if (s.charAt(0) == '0') {
            return s.length() == 1;
        }

        if (s.length() > 3) {
            return false;
        }

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            number = number * 10 + (s.charAt(i) - '0');
        }

        return number > 0 && number <= 255;
    }

    /**
     * @param s 就是数字字符串啦
     * @param index 从index开始，截取[index, index+1)的ip地址子串
     * @param subIpString 就是已经匹配的ip地址前缀，例如0.0.0.(还缺一位才够完整的ip地址)
     * @param count 记录ip地址前缀的个数，count == 3 作为递归终止条件
     * */
    private void findIpAddresses(String s, int index, String subIpString, int count) {

        if (index >= s.length()) {
            return;
        }

        if (count == 3) {
            String split = s.substring(index);
            if (split.length() > 3) {
                return;
            }
            if (this.isValidInteger(split)) {
                this.res.add(subIpString + split);
                return;
            }
            return;
        }

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String split = s.substring(index, index + i);
            if (this.isValidInteger(split)) {
                this.findIpAddresses(s, index + i, subIpString + split + ".", count + 1);
            }
        }
    }

    public static void main(String[] args) {
        String testCase = "0000";
        Solution s = new Solution();
        s.restoreIpAddresses(testCase);
        for (String ip : s.res) {
            System.out.println(ip);
        }
    }
}
