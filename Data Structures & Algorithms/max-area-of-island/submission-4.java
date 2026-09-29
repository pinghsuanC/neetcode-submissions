class Solution {
    int[][] dirs = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 1) continue;
                if(visited[i][j] == true) continue;
                res = Math.max(res, helper(grid, i, j));
            }
        }
        return res;
    }

    public int helper(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(grid[i][j] == 0) return 0;
        if(visited[i][j]) return 0;

        int area = 1;
        visited[i][j] = true; // make sure we don't count it multiple times
        for(int[] dir : dirs){
            area += helper(grid, i+dir[0], j+dir[1]);
        }

        return area;
    }
}
