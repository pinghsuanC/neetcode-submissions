class Solution {
    public int change(int amount, int[] coins) {
        /*
          define dp[i][j] as # ways you can make amount j with coins[0:i]
        */

        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0; i <= n; i++) dp[i][0] = 1;

        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= amount; j++){
                if(j < coins[i]) continue;
                dp[i][j] = dp[i+1][j];
                dp[i][j] += dp[i][j - coins[i]];
            }
        }

        return dp[0][amount];

    }
}
