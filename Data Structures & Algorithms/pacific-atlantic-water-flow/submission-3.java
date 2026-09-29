class Solution {

    int[][] DIRS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        /*
        intuition:

        since we are finding the cells that can flow both to pacific and atlantic
        
        -> part 1
        From the top & left, find where the pacific-adjacent cells can lead to. Those are cells that can flow into pacific

        -> part 2
        From the answers we found in part 1, find which ones can lead to atlantic
        
        */


        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) pacificQueue.add(new int[]{i, j});
                if(i == m - 1 || j == n -1) atlanticQueue.add(new int[]{i, j});
            }
        }

        helper(pacificQueue, pac, heights);
        helper(atlanticQueue, atl, heights);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && atl[i][j]) ans.add(Arrays.asList(i, j));
            }
        }

        
        return ans;
    }

    private void helper(Queue<int[]> q, boolean[][] ocean, int[][]heights){
        int m = heights.length, n = heights[0].length;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for(int[] d : DIRS){
                int nr = r + d[0], nc = c + d[1];
                if(nr < 0 || nc < 0 || nr >= m || nc >= n || ocean[nr][nc] == true || heights[r][c] > heights[nr][nc]) continue;
                q.add(new int[]{nr, nc});
            }
        }
    }

}






