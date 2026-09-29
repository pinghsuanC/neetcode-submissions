class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {0, 1}, {0, -1}, {-1, 0}
    };
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for(int[] arr : dp) Arrays.fill(arr, -1);

        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(max, helper(matrix, i, j));
            }
        }
        return max;
    }

    public int helper(int[][] matrix, int i, int j){
        int m = matrix.length, n = matrix[0].length;
        if(i < 0 || j < 0 || i >= m || j >=n) return 0;
        if(dp[i][j] >= 0) return dp[i][j];

        // move horizontally or vertically
        int max = 1;
        for(int[] dir : directions){
            int newI = i + dir[0], newJ = j + dir[1];
            if(newI < 0 || newJ < 0 || newI >= m || newJ >= n) continue;
            if(matrix[newI][newJ] > matrix[i][j]){
                max = Math.max(max, 1 + helper(matrix, newI, newJ));
            }
        }
        dp[i][j] = max;
        return max;
    }
}
