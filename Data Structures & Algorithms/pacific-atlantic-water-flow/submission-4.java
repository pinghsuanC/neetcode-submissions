class Solution {
    int[][] dirs = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] pacificValids = new boolean[m][n];
        boolean[][] atlanticValids = new boolean[m][n];

        // first find all valid cells that can flow into pacific ocean (in reverse starting from i == 0 || j == 0)
        Queue<int[]> pacific = new ArrayDeque<>();
        Queue<int[]> atlantic = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) {
                    pacific.add(new int[]{i, j});
                    pacificValids[i][j] = true;
                }
                if(i == m-1 || j == n-1){
                    atlantic.add(new int[]{i, j});
                    atlanticValids[i][j] = true;
                }
            }
        }

        while(!pacific.isEmpty()){
            int[] cur = pacific.poll();
            int val = heights[cur[0]][cur[1]];
            for(int[] dir : dirs){
                int newI = cur[0] + dir[0], newJ = cur[1] + dir[1];
                if(newI < 0 || newJ < 0 || newI >= m || newJ >= n) continue;
                if(pacificValids[newI][newJ]) continue;
                if(heights[newI][newJ] < val) continue;
                pacificValids[newI][newJ] = true;
                pacific.offer(new int[]{newI, newJ});
            }
        }

        while(!atlantic.isEmpty()){
            int[] cur = atlantic.poll();
            int val = heights[cur[0]][cur[1]];
            for(int[] dir : dirs){
                int newI = cur[0] + dir[0], newJ = cur[1] + dir[1];
                if(newI < 0 || newJ < 0 || newI >= m || newJ >= n) continue;
                if(atlanticValids[newI][newJ]) continue;
                if(heights[newI][newJ] < val) continue;
                atlanticValids[newI][newJ] = true;
                atlantic.offer(new int[]{newI, newJ});
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(atlanticValids[i][j] && pacificValids[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }
}
