class Solution {
    int[][] dirs = new int[][]{
        {0, 1}, {1, 0}
    };
    int[][] tabular;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        tabular = new int[m][n];
        for(int[] k : tabular) Arrays.fill(k, -1);
        tabular[m-1][n-1] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) tabular[i][j] = 0;
            }
        }
        return helper(obstacleGrid, 0, 0);
    }

    public int helper(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(tabular[i][j] >= 0) return tabular[i][j];

        int total = 0;
        for(int[] dir : dirs){
            int newI = dir[0] + i, newJ = dir[1] + j;
            total += helper(grid, newI, newJ);
        }
        tabular[i][j] = total;

        return total;
    }
}