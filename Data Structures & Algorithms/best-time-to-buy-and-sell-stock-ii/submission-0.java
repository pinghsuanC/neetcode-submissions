class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] d : dp) Arrays.fill(d, -1);

        return helper(prices, 0, 0);
    }

    public int helper(int[] prices, int i, int hasStock){
        if(i == prices.length) return 0;
        if(dp[i][hasStock] >= 0) return dp[i][hasStock];

        int max = 0;
        int noActions = helper(prices, i+1, hasStock);
        max = Math.max(noActions, max);
        if(hasStock == 1){
            int sell = helper(prices, i+1, 0) + prices[i];
            max = Math.max(sell, max);
        } else {
            int buy = helper(prices, i+1, 1) - prices[i];
            max = Math.max(buy, max);
        }
        dp[i][hasStock] = max;

        return max;
    }
}