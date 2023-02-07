package LeetCode904;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TLE
 *
 * @author Chanmoey
 * @date 2023年02月07日
 */
class Solution {

    public int totalFruit(int[] fruits) {

        if (fruits.length == 1) {
            return 1;
        }

        if (fruits.length == 2) {
            return 2;
        }

        Set<Integer> collect = new HashSet<>();
        int max = 0;
        int count;
        int i = 0;
        while (i < fruits.length - 1) {
            System.out.println("i = " + i);
            collect.clear();
            count = 1;
            collect.add(fruits[i]);
            int j = i + 1;
            for (; j < fruits.length; j++) {
                if (!collect.contains(fruits[j])) {

                    if (collect.size() == 1) {
                        i = j;
                    }

                    if (collect.size() >= 2) {
                        break;
                    }
                    count++;
                    collect.add(fruits[j]);
                } else {
                    count++;
                }
            }

            max = Math.max(max, count);
            if (j == fruits.length) {
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = new int[1000];
        Arrays.fill(num, 0);
        num[500] = 1;
        num[600] = 2;
        System.out.println(s.totalFruit(num));
    }
}
