package LeetCode1376;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年03月18日
 */
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) {
            return 0;
        }
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList();
        }
        for (int i = 0; i < n; i++) {
            if (i == headID) {
                continue;
            }
            int m = manager[i];
            list[m].add(i);
        }
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{headID,0});
        int result = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int master = cur[0];
            int currTime = cur[1];
            result = Math.max(result, currTime);
            for (int next: list[master]) {
                q.add(new int[]{next, currTime + informTime[master]});
            }
        }
        return result;
    }
}
