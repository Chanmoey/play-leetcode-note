package LeetCode421;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年01月27日
 */
class Solution {

    private static class Trie {
        private final Map<Integer, Trie> child;

        public Trie() {
            this.child = new HashMap<>();
        }
    }

    private Trie root;

    public int findMaximumXOR(int[] nums) {
        this.root = new Trie();
        int maxXor = 0;

        for (int num : nums) {

            Trie cur = this.root;

            for (int i = 31; i >= 0; i--) {
                int bit = this.getBit(num, i);

                if (!cur.child.containsKey(bit)) {
                    cur.child.put(bit, new Trie());
                }

                cur = cur.child.get(bit);
            }

            maxXor = Math.max(maxXor, this.maxXor(num));
        }

        return maxXor;
    }

    private int maxXor(int num) {
        Trie cur = this.root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            int curBit = this.getBit(num, i);
            int reqBit = (curBit == 0) ? 1 : 0;

            if (cur.child.containsKey(reqBit)) {
                maxXor |= (1 << i);
                cur = cur.child.get(reqBit);
            } else {
                cur = cur.child.get(curBit);
            }
        }

        return maxXor;
    }

    private int getBit(int num, int idx) {
        return (num & (1 << idx)) == 0 ? 0 : 1;
    }
}
