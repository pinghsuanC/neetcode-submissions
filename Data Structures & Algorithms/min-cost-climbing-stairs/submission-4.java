class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
        intuition: after paying for the step i, you can either choose i + 1 or i + 2
        from the destination n we know for sure we will step onto, we can unfold it backwards

        let dp[i] = the min cost it takes from i to n
        */
    
        int n = cost.length;
        int[] dp = new int[n + 2];

        for(int i = 2; i <=n; i++){
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i -2] + dp[i - 2]);
        }

        return dp[n];
    }
}
