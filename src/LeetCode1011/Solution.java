package LeetCode1011;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年11月23日
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1;

        int r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // mid越大，countDays越小
            if (countDays(weights, mid) <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int countDays(int[] weights, int capacity) {
        int res = 1;
        int nowCapacity = capacity;
        for (int weight : weights) {
            if (weight <= capacity) {
                if (weight <= nowCapacity) {
                    nowCapacity -= weight;
                } else {
                    nowCapacity = capacity;
                    nowCapacity -= weight;
                    res ++;
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("s.shipWithinDays(weights, 5) = " + s.shipWithinDays(weights, 5));
        System.out.println("s.countDays(weights, 5) = " + s.countDays(weights, 5));
        System.out.println(s.countDays(weights, 15));
    }
}
