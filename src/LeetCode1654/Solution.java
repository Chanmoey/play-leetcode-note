package LeetCode1654;

import java.util.*;

/**
 * 参考评论区的题解
 *
 * @author Chanmoey
 * @date 2022年03月20日
 */
class Solution {

    private static class Pair {
        int edge;
        boolean state;

        Pair(int edge, boolean state) {
            this.edge = edge;
            this.state = state;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int ele : forbidden) {
            list.add(ele);
        }
        HashSet<String> vis = new HashSet<>();

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, false));

        vis.add("f" + 0);
        vis.add("b" + 0);
        int level = 0;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                Pair rem = que.remove();
                if (rem.edge == x) {
                    return level;
                }

                int forward = rem.edge + a;
                int backward = rem.edge - b;
                boolean isBack = rem.state;

                if (forward < 6000 && !list.contains(forward) && !vis.contains("f" + forward)) {
                    que.add(new Pair(forward, false));
                    vis.add("f" + forward);
                }
                if (backward >= 0 && !list.contains(backward) && !isBack && !vis.contains("b" + backward)) {
                    que.add(new Pair(backward, true));
                    vis.add("b" + backward);
                }
            }
            level++;
        }
        return -1;
    }
}
