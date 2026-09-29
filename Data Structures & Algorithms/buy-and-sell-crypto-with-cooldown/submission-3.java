class Solution {
    int[][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        // 0 = false, 1 = true
        for(int[] d : dp) Arrays.fill(d, -1);

        return dfs(0, 1, prices);
    }

    private int dfs(int i, int buying, int[] prices){
        if(i >= prices.length) return 0;
        if(dp[i][buying] >= 0) return dp[i][buying];

        int cooldown = dfs(i+1, buying, prices);
        if(buying == 1){
            int buy = dfs(i+1, 0, prices) - prices[i];
            dp[i][buying] = Math.max(cooldown, buy);
        } else {
            int sell = dfs(i+2, 1, prices) + prices[i];
            dp[i][buying] = Math.max(cooldown, sell);
        }

        return dp[i][buying];
    }
    
}
