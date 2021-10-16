package LeetCode123;

class Solution1 {
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        if (prices.length == 2) {
            return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        }

        int firstBuy = Integer.MAX_VALUE;
        int secondBuy = Integer.MAX_VALUE;
        int midProfit = 0;
        int finalProfit = 0;

        for (int price : prices) {

            firstBuy = Math.min(firstBuy, price);
            midProfit = Math.max(midProfit, price - firstBuy);

            secondBuy = Math.min(secondBuy, price - midProfit);
            finalProfit = Math.max(finalProfit, price - secondBuy);
        }

        return finalProfit;
    }
}
