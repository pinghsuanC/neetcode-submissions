class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {0, 1}
    };
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                for(int[] dir : directions) dp[i][j] += dp[i + dir[0]][j + dir[1]];
            }
        }

        return dp[0][0];
    }
}
