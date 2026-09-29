class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {0, 1}
    };

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // define dp[i][j] as # ways to reach grid[i][j]
        dp[m - 1][n - 1] = 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    private int helper(int m, int n, int i, int j){
        if(i >= m || i < 0 || j >= n || j < 0) return 0;
        if(i == m - 1 && j == n - 1) return 1;

        int res = 0;
        for(int[] dir : directions) res += helper(m, n, i+dir[0], j+dir[1]);

        
        return res;
    }
} 
