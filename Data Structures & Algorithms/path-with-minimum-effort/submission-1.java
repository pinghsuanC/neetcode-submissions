class Solution {
    int[][] dirs = new int[][]{
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    public int minimumEffortPath(int[][] heights) {
        /*
        intuition:
        effort = max absolute difference in heights between two consecutive cells of the route
        
        want: min effort required to travel from top-left to bottom-right
        
        
        when see min, immediate thought would be BFS
        for each cell, accumulate the min effort to reach that cell
        abort if out of boundary
        continue until there're no more to be processed
        record the min effort in the efforts board
        */
        
        
        if(heights.length == 0) return 0;
        int ROW = heights.length, COL = heights[0].length;
        int[][] efforts = new int[ROW][COL];
        for(int[] row : efforts){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {row, col, currentEffort}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int r = node[0], 
                c = node[1], 
                currentEffort = node[2],
                h = heights[r][c];

            for(int[] dir : dirs){
                // get the new index
                int nr = dir[0]+r,
                    nc = dir[1]+c;

                if(nr < 0 || nc < 0 || nr >= ROW || nc >= COL) continue; // abort out of bounds

                int nh = nh = heights[nr][nc];
                int weight = Math.abs(nh - h);
                int newEffort = Math.max(currentEffort, weight);

                if(newEffort >= efforts[nr][nc]) continue;      // effort is not greater, abort the path
                
                efforts[nr][nc] = newEffort;
                // add to queue to further explore
                pq.offer(new int[]{nr, nc, newEffort});
            }
        }

        return efforts[ROW-1][COL-1] == Integer.MAX_VALUE ? 0 : efforts[ROW-1][COL-1];
    }
}