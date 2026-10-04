class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        /*
        +1 only if
            -> the side is water
            -> the side exceeds boundary
        */

        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res = helper(grid, i, j);
                    return res;
                }
            }
        }

        return res;
    }

    public int helper(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0){
            return 1;
        }
        if(visited[i][j]) return 0;
        visited[i][j] = true;

        int res = 0;
        for(int[] dir : directions){
            int newI = i + dir[0], newJ = j + dir[1];
            if(newI < 0 || newI >= m || newJ < 0 || newJ >= n){
               res+=1;
               continue;
            }
            res += helper(grid, newI, newJ);
        }

        return res;
    }
}