package LeetCode869;

import java.util.ArrayList;
import java.util.List;

/**
 * TLE
 *
 * @author Chanmoey
 * @date 2022年08月26日
 */
class Solution {

    private final List<Integer> perm = new ArrayList<>();

    public boolean reorderedPowerOf2(int n) {
        List<Integer> list = getIntList(n);
        perm(list, 0, list.size() - 1);
        for (Integer i : perm) {
            if (i == 1) {
                return true;
            }
            if (i % 2 == 0) {
                return true;
            }
        }

        return false;
    }

    private void swap(List<Integer> list, int i, int k) {
        Integer tem = list.get(i);
        list.add(i, list.get(k));
        list.add(k, tem);
    }

    private List<Integer> getIntList(int n) {
        List<Integer> res = new ArrayList<>();
        while (n != 0) {
            res.add(n % 10);
            n /= 10;
        }
        return res;
    }

    private void perm(List<Integer> list, int k, int m) {
        if (k == m) {
            if (!list.get(0).equals(0)) {
                int order = 0;
                for (Integer in : list) {
                    order = order * 10 + in;
                }
                perm.add(order);
            }
        } else {
            for (int i = k; i <= m; i++) {
                swap(list, i, k);
                perm(list, k + 1, m);
                swap(list, i, k);
            }
        }
    }
}
