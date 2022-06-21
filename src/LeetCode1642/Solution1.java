package LeetCode1642;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 直觉上，梯子满足任何高度差，所以我们希望只有在更大的高度差时，使用梯子。
 * 所以优先使用砖块，当砖块数目不够到达下一层楼时，在先前用砖块走过的楼中，最大的高度差用梯子替换，
 * 那么梯子就多出了: 剩余数目 + 被梯子替代的高度差。
 *
 * @author Chanmoey
 * @date 2022年06月21日
 */
class Solution1 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] > heights[i + 1]) {
                continue;
            }
            int diff = heights[i + 1] - heights[i];
            bricks -= diff;
            maxHeap.add(diff);

            if (bricks < 0) {
                bricks += maxHeap.poll();
                if (ladders > 0) {
                    ladders--;
                } else {
                    return i;
                }
            }
        }

        return heights.length - 1;
    }
}
