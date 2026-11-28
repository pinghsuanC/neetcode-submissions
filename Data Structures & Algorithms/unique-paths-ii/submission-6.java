class Solution {
    int[][] dirs = new int[][]{
        {1, 0}, {0, 1}
    };
    int[][] tab;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        top-left -> bottom-right
        1 = obstacle
        0 = space
        path stops @ 1s

        need: total # of viable paths
        
        */

        if(obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        tab = new int[m+1][n+1];
        tab[m-1][n-1] = 1;

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j>=0; j--){
                if(obstacleGrid[i][j] == 1) {
                    tab[i][j] = 0;
                    continue;
                }
                for(int[] dir : dirs){
                    int nextI = dir[0] + i;
                    int nextJ = dir[1] + j;
                    tab[i][j] += tab[nextI][nextJ];
                }
            }
        }

        return tab[0][0];
    }


    public int helper(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(grid[i][j] == 1) return 0;
        if(i == m-1 && j == n-1) return 1;

        int res = 0;
        for(int[] dir : dirs){
            int newI = dir[0]+ i;
            int newJ = dir[1] + j;
            res += helper(grid, newI, newJ);
        }

        return res;
    }

}