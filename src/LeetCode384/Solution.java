package LeetCode384;

import java.util.Random;

/**
 * @author Chanmoey
 * @date 2022年08月02日
 */
class Solution {

    private final int[] origin;
    private final int[] shuffle;
    private final Random random = new Random();

    public Solution(int[] nums) {
        this.origin = nums.clone();
        this.shuffle = nums.clone();
    }

    public int[] reset() {
        return this.origin;
    }

    public int[] shuffle() {
        int last = shuffle.length - 1;
        for (int i = last; i >= 0; i--) {

            int randomIdx = random.nextInt(i + 1);
            int temp = shuffle[i];
            shuffle[i] = shuffle[randomIdx];
            shuffle[randomIdx] = temp;
        }

        return shuffle;
    }
}
