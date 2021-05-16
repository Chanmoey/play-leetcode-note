package LeetCode349;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();

        for (int j : nums1) {
            set1.add(j);
        }

        Set<Integer> set2 = new HashSet<Integer>();

        for (int j : nums2) {
            set2.add(j);
        }

        set1.retainAll(set2);

        int[] res = new int[set1.size()];
        Iterator<Integer> iter = set1.iterator();
        int i = 0;
        while (iter.hasNext()){
            res[i] = iter.next();
            i ++;
        }

        return res;
    }
}
