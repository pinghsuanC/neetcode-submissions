public class Solution {
    Integer[][] dp;
    public int integerBreak(int n) {
        dp = new Integer[n+1][n+1];
        return dfs(n, n - 1);
    }

    private int dfs(int n, int i) {
        if (Math.min(n, i) == 0) return 1;
        if(dp[n][i] != null) return dp[n][i];

        if (i > n) return dfs(n, n);

        dp[n][i] = Math.max(i * dfs(n - i, i), dfs(n, i - 1));

        return dp[n][i];
    }
}