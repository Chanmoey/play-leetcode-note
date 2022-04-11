package LeetCode682;

/**
 * @author Chanmoey
 */
class Solution {
    public int calPoints(String[] ops) {
        int[] num = new int[ops.length];
        int index = 0;
        for (String op : ops) {
            if (Character.isDigit(op.charAt(0)) || op.length() > 1) {
                num[index] = Integer.parseInt(op);
                index++;
            } else if (op.charAt(0) == '+') {
                num[index] = num[index - 1] + num[index - 2];
                index++;
            } else if (op.charAt(0) == 'D') {
                num[index] = num[index - 1] * 2;
                index++;
            } else { // op.charAt(0) == 'c'
                index--;
            }
        }

        return this.scopeSum(num, index);
    }

    private int scopeSum(int[] arr, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
