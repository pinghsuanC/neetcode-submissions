class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // Starting from the chests, expand step-by-step
        // i.e. expand step 1, then check all the step2 positions.etc
        
        // 1. add all the chest positions to queue
        // 2. while queue is not empty, poll().
            // 2.1 set that position to visited
            // 2.2 add next positions at each direction to queue
            // 2.3 update the next grid value with current value + 1

        
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0) continue;
                q.offer(new int[]{i, j});
            }
        }

        if(q.size() == 0) return;

        int[][] dirs = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
        };
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];
            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                q.offer(new int[]{r, c});
                grid[r][c] = grid[row][col]+1;
            }
        }

    }
}