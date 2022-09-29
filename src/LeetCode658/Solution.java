package LeetCode658;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年09月29日
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int idx = 0;

        if (arr[0] > x) {
            while (idx < k) {
                res.add(arr[idx++]);
            }

            res.sort(Integer::compareTo);
            return res;
        }

        if (arr[arr.length - 1] < x) {
            idx = arr.length - 1;
            int count = 0;
            while (count < k) {
                res.add(arr[idx--]);
                count++;
            }

            res.sort(Integer::compareTo);
            return res;
        }

        int start = binSearch(arr, x);

        int i;
        int j;
        int count;
        if (arr[start] == x) {
            i = start - 1;
            count = 1;
            res.add(x);
        } else {
            i = start;
            count = 0;
        }
        j = start + 1;

        while (i >= 0 && j <= arr.length - 1 && count < k) {
            if (Math.abs(arr[i] - x) == Math.abs(arr[j] - x) ||
                    Math.abs(arr[i] - x) < Math.abs(arr[j] - x)) {
                res.add(arr[i]);
                i--;
            } else {
                res.add(arr[j]);
                j++;
            }
            count++;
        }

        if (i < 0) {
            while (j <= arr.length - 1 && count < k) {
                res.add(arr[j]);
                j++;
                count++;
            }
        }

        if (j >= arr.length) {
            while (i >= 0 && count < k) {
                res.add(arr[i]);
                i--;
                count++;
            }
        }

        res.sort(Integer::compareTo);
        return res;
    }

    private int binSearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l - 1;
    }
}
