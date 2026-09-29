class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, fresh = 0, t = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        // add rots to queue
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) queue.add(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }

        // BFS until queue is empty
        while(!queue.isEmpty() && fresh > 0){
            int s = queue.size();
            for(int k = 0; k < s; k++){
                int[] rot = queue.poll();
                for(int[] dir : directions){
                    int newR = rot[0] + dir[0], newC = rot[1] + dir[1];
                    if(newR < 0 || newC < 0 || newR >= m || newC >= n || grid[newR][newC] != 1) continue;
                    grid[newR][newC] = 2;
                    queue.offer(new int[]{newR, newC});
                    fresh--;
                }
            }
            
            t++;
        }

        return fresh == 0 ? t : -1;
    }
}
