class Solution {
    int[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n + 1][2];
        // 0 = false, 1 = true
        
        for(int i = n - 1; i >= 0; i--){
            for(int buying = 0; buying <= 1; buying++){
                if(buying == 1){
                    int buy = dp[i+1][0] - prices[i];
                    int cooldown = dp[i+1][1];
                    dp[i][buying] = Math.max(cooldown, buy);
                } else {
                    int sell = (i + 2 < n) ? dp[i+2][1] + prices[i] : prices[i];
                    int cooldown = dp[i+1][0];
                    dp[i][buying] = Math.max(cooldown, sell);
                }
            }
        }

        return dp[0][1];

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
