class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }
        return helper(n, 0);
    }

    private int helper(int n, int i){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        dp[i] = helper(n, i+1) + helper(n, i+2);
        return dp[i];
    }
}
