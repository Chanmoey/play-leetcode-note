package LeetCode131;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 1) {
            List<String> item = new ArrayList<>();
            item.add(s);
            this.res.add(item);
            return this.res;
        }

        List<String> item = new ArrayList<>();
        this._partition(s, 0, item);
        return res;
    }

    private void _partition(String s, int index, List<String> list) {

        if (index == s.length()) {
            this.res.add(list);
            return;
        }

        for (int i = 1; index + i <= s.length(); i++) {
            String sub = s.substring(index, index + i);
            if (this.isPalindrome(sub)) {
                List<String> newList = new ArrayList<>(list);
                newList.add(sub);
                this._partition(s, index + i, newList);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}
