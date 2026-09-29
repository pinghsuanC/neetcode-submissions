class Solution {
    public int orangesRotting(int[][] grid) {
        // intuition: use BFS, every unit of time passed, the rot spreads
        // use a queue to track all the indices
        // while the queue is not empty
            // grab all the fruts, for each one, mark them as rotten
            // for each one, when marking them rotten, grab any fresh fruit from 4 directions if any, put the fresh fruit in the queue
        // track # while loops as t


        
        int m = grid.length, n = grid[0].length, countFresh = 0, t = 0;
        int[][] directions = new int[][]{{-1, 0},{1, 0},{0, -1}, {0, 1}};
        Queue<int[]> queue = new ArrayDeque<>();

        // initialize
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 2) queue.offer(new int[]{r, c});
                if(grid[r][c] == 1) countFresh++;
            }
        }

        while(!queue.isEmpty() && countFresh > 0){
            List<int[]> arr = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++){
                int[] rot = queue.poll();

                for(int[] dir : directions){
                    int checkR = rot[0] + dir[0];
                    int checkC = rot[1] + dir[1];
                    if(checkR < 0 || checkC < 0 || checkR >= m || checkC >= n) continue;
                    if(grid[checkR][checkC] == 1) {
                        grid[checkR][checkC] = 2;
                        queue.offer(new int[]{checkR, checkC});
                        countFresh--;
                    }
                }
            }
            t++;
        }

        return countFresh == 0 ? t : -1;
    }
}
