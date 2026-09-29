class Solution {
    public int maxProfit(int[] prices) {
        int minP = prices[0], maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            minP = Math.min(prices[i], minP);
            maxProfit = Math.max(prices[i] - minP, maxProfit);
        }

        return maxProfit;
    }
}
