class Solution {
    int[][] dirs = new int[][]{
        {1, 0}, {0, 1}, {0, -1}, {-1, 0}
    };
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != '1') continue;
                count++;
                helper(grid, i, j);
            }
        }
        return count;
    }

    public void helper(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return;

        if(grid[i][j] == '1'){
            grid[i][j] = '3';
            for(int[] dir : dirs) helper(grid, i+dir[0], j+dir[1]);
        }
    }
}
