class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m+1][n+1];
        return helper(m, n, 0, 0);
    }

    public int helper(int m, int n, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(dp[i][j] != null) return dp[i][j];

        if(i == m - 1 && j == n - 1) return 1;

        dp[i][j] = helper(m, n, i+1, j) + helper(m, n, i, j+1); 
        return dp[i][j];
    }
}
