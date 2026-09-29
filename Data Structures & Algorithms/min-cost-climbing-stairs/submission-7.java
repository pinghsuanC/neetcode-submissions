class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 2];
        

        for(int i = cost.length - 1; i >= 0; i--){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    public int helper(int[] cost, int i){
        if(i >= cost.length) return 0;
        if(dp[i] >= 0) return dp[i];

        int cost1 = cost[i] + helper(cost, i+1);
        int cost2 = cost[i] + helper(cost, i+2);
        dp[i] = Math.min(cost1, cost2);

        return dp[i];
    }
}
