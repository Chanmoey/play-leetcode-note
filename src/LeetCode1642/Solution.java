package LeetCode1642;

/**
 * 错误的，如果每层楼的高度差是从左到右逐步增加的，那么就可以。
 *
 * @author Chanmoey
 * @date 2022年06月21日
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int[] diff = new int[heights.length];
        int maxDiffIdx = -1;
        int maxDiff = -1;
        for (int i = 0; i < heights.length - 1; i++) {
            int diffHeight = heights[i + 1] - heights[i];
            diff[i] = Math.abs(Math.min(diffHeight, 0));

            if (diff[i] > maxDiff) {
                maxDiff = diff[i];
                maxDiffIdx = i;
            }
        }

        int reach = 1;
        for (int i = 0; i < heights.length - 1; i++) {
            if (diff[i] > 0) { // 有高度差。
                if (i == maxDiffIdx) {
                    // 使用梯子。
                    if (ladders > 0) {
                        ladders--;
                        reach++;
                    } else { // 无梯子了，使用砖块。
                        if (bricks >= diff[i]) {
                            bricks -= diff[i];
                            reach++;
                        }
                    }
                } else {
                    if (bricks >= diff[i]) { // 不在最大高度差的时候，优先考虑使用砖块。
                        bricks -= diff[i];
                        reach++;
                    } else { // 砖块用完了，使用梯子
                        if (ladders > 0) {
                            ladders--;
                            reach++;
                        }
                    }

                }
                if (bricks <= 0 && ladders <= 0) {
                    break;
                }
            }
        }

        return reach;
    }
}
