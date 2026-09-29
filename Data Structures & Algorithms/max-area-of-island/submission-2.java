class Solution {
    List<Integer> visited;
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        visited = new ArrayList<>();
        max = 0;
        // traverse, find the first 1
        // get total area by recursrive function
        // OR: just update a global max continuously in the single call recursive call stack
        //  see which one works
        // return max

        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited.contains(i*n+j)) continue;
                if(grid[i][j] == 0) continue;
                int area = helper(grid, i, j, 0);
                max = Math.max(max, area);
            }
        }

        return max;
    }

    private int helper(int[][] grid, int i, int j, int acc){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        if(grid[i][j] == 0 || visited.contains(i*n+j)) return 0;

        visited.add(i*n+j);
        int a = helper(grid, i+1, j, 0);
        int b = helper(grid, i-1, j, 0);
        int c = helper(grid, i, j+1, 0);
        int d = helper(grid, i, j-1, 0);

        return 1 + a + b + c + d;
    }
}
