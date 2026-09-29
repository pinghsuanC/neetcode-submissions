class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];
        for(int[] d : dp) Arrays.fill(d, -1);
        return helper(prices, true, 0);
    }

    private int helper(int[] prices, boolean canBuy, int i){
        if(i >= prices.length) return 0;
        int buyingIndex = canBuy == true ? 1 : 0;
        if(dp[i][buyingIndex] >= 0) return dp[i][buyingIndex];

        int cooldown = helper(prices, canBuy, i+1);
        if(canBuy){
            int buy = helper(prices, false, i+1) - prices[i];
            dp[i][buyingIndex] = Math.max(cooldown, buy);
        } else {
            int sell = helper(prices, true, i+2) + prices[i];
            dp[i][buyingIndex] = Math.max(cooldown, sell);
        }

        return dp[i][buyingIndex];
    }
}
