class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        dp = new Integer[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(helper(matrix, i, j), max);
            }
        }

        return max;
    }

    public int helper(int[][] matrix, int i, int j){
        int m = matrix.length, n = matrix[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int max = 1;
        for(int[] dir : directions){
            int newI = dir[0] + i, newJ = dir[1] + j;
            if(newI < 0 || newJ < 0 || newI >= m || newJ >= n) continue;
            if(matrix[i][j] >= matrix[newI][newJ]) continue; // not an increasing path

            // check length
            max = Math.max(max, 1+helper(matrix, newI, newJ));
        }
        dp[i][j] = max;

        return max;
    }
}
