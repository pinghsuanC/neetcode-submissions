class Solution {
    boolean[][] visited;
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        max = 0;
        // traverse, find the first 1
        // get total area by recursrive function
        // OR: just update a global max continuously in the single call recursive call stack
        //  see which one works
        // return max

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;
                if(grid[i][j] == 0) continue;
                max = Math.max(max, helper(grid, i, j));
            }
        }

        return max;
    }

    private int helper(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        if(grid[i][j] == 0 || visited[i][j] == true) return 0;

        visited[i][j] = true;
        int a = helper(grid, i+1, j);
        int b = helper(grid, i-1, j);
        int c = helper(grid, i, j+1);
        int d = helper(grid, i, j-1);

        return 1 + a + b + c + d;
    }
}
