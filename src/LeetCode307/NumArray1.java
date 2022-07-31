package LeetCode307;

/**
 * Time Limit Exceeded
 *
 * @author Chanmory
 * @date 2022年7月31日
 */
class NumArray1 {

    private final BinaryIndexedTree binaryIndexedTree;

    /**
     * 二叉索引树
     */
    static class BinaryIndexedTree {
        int[] nums;
        int[] bit;
        int n;

        public BinaryIndexedTree(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            this.bit = new int[n + 1];
            for (int i = 0; i < n; i++) {
                init(i, nums[i]);
            }
        }

        private void init(int i, int val) {
            i++;
            while (i <= n) {
                bit[i] += val;
                i += (i & -i);
            }
        }

        private void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            init(i, diff);
        }

        private int getSum(int i) {
            i++;
            int res = 0;
            while (i > 0) {
                res += bit[i];
                i -= (i & -i);
            }

            return res;
        }
    }

    public NumArray1(int[] nums) {
        binaryIndexedTree = new BinaryIndexedTree(nums);
    }

    public void update(int index, int val) {
        binaryIndexedTree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return binaryIndexedTree.getSum(right) - binaryIndexedTree.getSum(left - 1);
    }
}
