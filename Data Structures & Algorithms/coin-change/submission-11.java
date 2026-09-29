class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int c : coins){
            for(int i = 0; i <= amount; i++){
                if(i < c) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
