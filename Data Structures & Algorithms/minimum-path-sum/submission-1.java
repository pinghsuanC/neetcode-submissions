class Solution {
    int[][] dirs = new int[][]{
        {1, 0}, {0, 1}
    };
    int[][] tab;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        tab = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                tab[i][j] = Integer.MAX_VALUE;
            }
        }
        tab[m-1][n] = 0;
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int min = Math.min(tab[i+1][j], tab[i][j+1]);
                tab[i][j] = min + grid[i][j];
            }
        }
        return tab[0][0];
    }

    public int helper(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i == m-1 && j == n-1) return grid[i][j];
        if(i < 0 || j < 0 || i >= m || j >= n) return Integer.MAX_VALUE / 2;
        if(tab[i][j] >= 0) return tab[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int[] dir : dirs){            
            min = Math.min(min, helper(grid, i+dir[0], j+dir[1]));
        }
        tab[i][j] = min + grid[i][j];
        
        return min + grid[i][j];
    }
}