class Solution {
    int[][] dirs = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public int swimInWater(int[][] grid) {
        // Starting from the top left square (0, 0), 
        // return the minimum amount of time it will take until it is possible to reach the bottom right square (n - 1, n - 1).
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // int[] => [cost, i, j]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        queue.offer(new int[]{grid[0][0], 0, 0});

        int cost = 0;
        while(!queue.isEmpty()){
            
            int[] cur = queue.poll();
            if(visited[cur[1]][cur[2]]) continue;
            visited[cur[1]][cur[2]] = true;

            if(cur[1] == m-1 && cur[2] == n-1) {
                cost = cur[0];
                break;
            }
            // calculate the costs of paths for each neighbour
            for(int[] dir : dirs){
                int newI = dir[0]+cur[1], newJ = dir[1]+cur[2];
                if(newI < 0 || newJ < 0 || newI >= m || newJ >= n) continue;
                int pathCost = Math.max(cur[0], grid[newI][newJ]);
                queue.offer(new int[]{pathCost, newI, newJ});
            }
        }

        return cost;
    }
}
