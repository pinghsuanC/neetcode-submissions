class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int res = helper(coins, amount);
        return Integer.compare(res, (int)1e9) == 0 ? -1 : res;
    }

    private int helper(int[] coins, int amount){
        if(dp[amount] >= 0) return dp[amount];
        if(amount == 0) return 0;

        int res = (int)1e9;
        for(int c : coins){
            if(c > amount) continue;

            int find = 1 + helper(coins, amount - c);
            if(Integer.compare(res, find) != 0){
                res = Math.min(find, res);
            }
        }
        dp[amount] = res;

        return res;
    }
}
