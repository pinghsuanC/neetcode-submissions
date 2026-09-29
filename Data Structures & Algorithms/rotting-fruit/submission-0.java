class Solution {
    public int orangesRotting(int[][] grid) {
        // Start with a queue
        // add rotten fruit {i, j} to queue
        // initiate t = 0
        // while queue is not empty
            // poll the fruit. check 4 directions. 
            // for each direction, if it exceeds boundary or hits a wall or another rotten fruit, do nothing.
            // if there is a fruit, mark that fruit as rotten. Add that fruit to the queue.
        // Do a final loop. if there is any remaining fresh fruit, return -1. else return true.
        //      optimize by saving their indexing number (i*n+j) in a set. If it's rotten, remove it.
        //      if there is anything left at the end, return -1.


        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
                if(grid[i][j] == 1) set.add(i*n+j);
            }
        }

        if(set.size() == 0) return 0;
        if(q.size() == 0) return -1;

        int t = 0;
        int[][] directions = {
            {-1, 0}, {1, 0},
            {0, -1}, {0, 1}
        };
        while(!q.isEmpty()){
            List<int[]> nodes = new ArrayList<>();
            while(!q.isEmpty()){
                nodes.add(q.poll());
            }
            int count = 0;
            for(int i = 0; i < nodes.size(); i++){
                int[] node = nodes.get(i);
                int r = node[0], c = node[1];
                for(int[] dir : directions){
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if(newR < 0 || newR >= m || newC < 0 || newC >= n || grid[newR][newC] != 1){
                        continue;
                    }
                    //System.out.println("Rotting in t " + t + " => [" + newR + " , " + newC + " ].");
                    q.offer(new int[]{newR, newC});
                    grid[newR][newC] = 2;
                    set.remove(newR*n+newC);
                    count++;
                }
            }
            if(count > 0) t++;
        }

        if(set.size() > 0) return -1;
        return t;
    }
}
