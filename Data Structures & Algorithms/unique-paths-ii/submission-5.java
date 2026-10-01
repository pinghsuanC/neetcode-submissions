class Solution {
    
    int[][] directions = new int[][]{
        {1, 0}, {0, 1}
    };
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // update in a bit 
        dp = new int[m+1][n+1];
        //for(int[] row : dp) Arrays.fill(row, -1);
        dp[m-1][n-1] = 1;

        
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] += dp[i+1][j] + dp[i][j+1];
            }
        }


        return dp[0][0];
    }

    // dp 
    public int helper(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(dp[i][j] >= 0) return dp[i][j];
        if(grid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        
        int res = 0;
        for(int[] dir : directions){
            res += helper(grid, i+dir[0], j+dir[1]);
        }
        dp[i][j] = res;
        return res;
    } 

    
}