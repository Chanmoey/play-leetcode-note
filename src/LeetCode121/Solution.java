package LeetCode121;

class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        if (prices.length == 2) {
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        }

        int output = -prices[0];
        int profit = Integer.MIN_VALUE;

        for (int price : prices) {
            if (price + output > profit) {
                profit = price + output;
            }

            if (output < -price) {
                output = -price;
            }
        }

        return profit;
    }
}
