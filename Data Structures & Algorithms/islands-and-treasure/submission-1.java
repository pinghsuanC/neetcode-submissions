class Solution {
    int[][] dirs = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> chests = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) chests.offer(new int[]{i, j});
            }
        }

        while(!chests.isEmpty()){
            int size = chests.size();
            for(int i = 0; i < size; i++){
                int[] chest = chests.poll();
                int newDist = grid[chest[0]][chest[1]] + 1;
                for(int[] dir : dirs){
                    int newI = chest[0] + dir[0], newJ = chest[1] + dir[1];
                    if(newI < 0 || newJ < 0 || newI >= m || newJ >= n || grid[newI][newJ] <= 0) continue;
                    if(newDist < grid[newI][newJ]){
                        grid[newI][newJ] = newDist;
                        chests.offer(new int[]{newI, newJ});
                    }
                }
            }
        }

    }

}
