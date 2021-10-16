package LeetCode123;

class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        if (prices.length == 2) {
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        }

        int[] first = new int[prices.length];
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            first[i] = Math.max(first[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        int[] second = new int[prices.length];
        int maxPrice = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            second[i] = Math.max(second[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        int res = second[0];

        for (int i = 0; i < prices.length - 1; i++) {
            res = Math.max(res, first[i] + second[i + 1]);
        }
        res = Math.max(res, first[prices.length - 1]);

        return res;
    }
}