package LeetCode309;

class Solution {

    final static int ONE = 1;
    final static int TWO = 2;

    public int maxProfit(int[] prices) {

        if (prices.length <= ONE) {
            return 0;
        }

        if (prices.length == TWO) {
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(0, buy[0] + prices[1]);
        for (int i = 2; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }

        return sell[sell.length - 1];
    }
}
