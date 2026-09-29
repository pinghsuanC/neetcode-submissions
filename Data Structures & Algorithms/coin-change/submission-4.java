class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        int res = helper(coins, amount);
        return (res == (int) 1e9) ? -1 : res;
    }

    private int helper(int[] coins, int amount){
        if(amount == 0) return 0;
        if(dp[amount]!=0) return dp[amount];

        int ans = (int) 1e9;
        for(int c : coins){
            if(c > amount) continue;
            int route1 = 1 + helper(coins, amount-c);
            ans = Math.min(ans, route1);
        }
        dp[amount] = ans;
        return ans;
    }
}
