package LeetCode967;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> res = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(list, n, k);
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }

    public void dfs(List<Integer> list, int n, int k) {
        if (list.size() >= n) {
            int number = 0;
            for (Integer integer : list) {
                number = number * 10 + integer;
            }
            res.add(number);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (Math.abs(list.get(list.size() - 1) - i) == k) {
                list.add(i);
                dfs(list, n, k);
                list.remove(list.size() - 1);
            }
        }
    }
}
