class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // general intuition:
        // 1. find everything that can flow into pacific
        // 2. within the ones that can flow into pacific, find the ones that flow into atlantic
        
        /* 
            To check whether a point can flow into pacific
            == 
            check whether there is a valid path that goes from the point to the edge
            
            Observe from the example
                i) anything with i = 0 is valid. anything with j = 0 is valid
                ii) any flow into pacific will be flowing through i==0 or j == 0
            
            And flowing into == you can climb up
            So we can find vertices that has connection to at least one i==0 or j == 0
            and continue until we can't find any. Can do this by queue and BFS.


            Observe from atlantic
                i) anything with i == m-1 is valid, anthing with j = n-1 is valid.
                ii) if we already have a set of point, it's easy to check if there is a path down to those edges
                -> maybe there is an easier way when we get here

        */

        int m = heights.length, n = heights[0].length;
        boolean[][] valids = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> qA = new ArrayDeque<>();
        List<List<Integer>> pairs = new ArrayList<>();
        
        // add all the points from top
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 || j == 0) {
                    q.offer(new int[]{i, j});
                    valids[i][j] = true;
                }
                if(i == m -1 || j == n - 1){
                    qA.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // find valid points for pacific
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int[] node = q.poll();
            int val = heights[node[0]][node[1]];
            for(int[] dir : directions){
                int r = node[0]+dir[0];
                int c = node[1]+dir[1];
                if(r < 0 || r >= m || c < 0 || c >= n) continue;
                if(heights[r][c] < val || valids[r][c] == true) continue;
                valids[r][c] = true;
                q.offer(new int[]{r, c});
            }
        }

        // find valid points for atlantics
        while(!qA.isEmpty()){
            int[] node = qA.poll();
            int val = heights[node[0]][node[1]];
            int row = node[0], col = node[1];
            if(valids[row][col] == true){
                List<Integer> arr = new ArrayList<>();
                arr.add(row);
                arr.add(col);
                pairs.add(arr);
            }
            for(int[] dir : directions){
                int r = node[0]+dir[0],
                    c = node[1]+dir[1];
                if(r < 0 || r >=m || c < 0 || c >= n) continue;
                if(heights[r][c] < val) continue;
                if(visited[r][c]) continue;
                qA.offer(new int[]{r, c});
                visited[r][c] = true;
            }
        }

        return pairs;
    }

}






