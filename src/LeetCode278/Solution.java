package LeetCode278;

/**
 * @author Chanmoey
 * @date 2022年01月07日
 */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
