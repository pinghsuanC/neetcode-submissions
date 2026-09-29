class Solution {
    public int coinChange(int[] coins, int amount) {
        // intuition: build from bottom, from money == 0 to amount
        // [1, 4, 5, 10]
        
        // dp[amount] = min coins needed to get amount
        // dp[0] = 0
        // dp[1] = 1
        // dp[2] = -1
        // dp[5] = 1
        // dp[10] = either take 1 from 10, or take coint 5 + dp[5]

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 0; i <= amount; i++){
            for(int c : coins){
                if(i < c) continue;
                dp[i] = Math.min(1 + dp[i - c], dp[i]);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
