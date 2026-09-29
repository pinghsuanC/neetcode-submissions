class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];
        for(int[] d : dp) Arrays.fill(d, -1);
        
        return helper(prices, 0, 1);
    }

    public int helper(int[] prices, int i, int canBuy){
        if(i >= prices.length) return 0;
        if(dp[i][canBuy] >= 0) return dp[i][canBuy];

        int coolOff = helper(prices, i+1, canBuy);
        if(canBuy == 1){
            int buy = helper(prices, i+1, 0) - prices[i];
            dp[i][canBuy] = Math.max(coolOff, buy);
        } else {
            int sell = helper(prices, i+2, 1) + prices[i];
            dp[i][canBuy] = Math.max(coolOff, sell);
        }

        return dp[i][canBuy];
    }
}
