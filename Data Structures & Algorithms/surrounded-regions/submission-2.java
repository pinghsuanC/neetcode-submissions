class Solution {
    public void solve(char[][] board) {
        // initial intuition:
        // Observation: the "not surrounded" will only happen when one O in the group touches the bound.
            // if none of te O touche the bounds, it's going to be in the middle.
        // traverse graph for the first time, find positions of O
        // Create a boolena map of MxN. mark positions of O as true.
        // check if O is at the bounds. if so mark it as F.
        // update the posiiotn of the F Os in queue.
        // until queue becomes empty, makr everything the FO can spread to F.
        // Loop the boolena map. Everything marked as T set to X.

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] mapO = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == m-1 || j == n-1)) {
                    board[i][j] = 'T';
                    q.offer(new int[]{i, j}); 
                }
             }
        }

        int[][] directions = {
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1}
        };
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0], c = node[1];
            for(int[] dir : directions){
                int row = r+dir[0],
                    col = c+dir[1];
                if(row < 0 || row >= m || col < 0 || col >= n) continue;
                if(board[row][col] != 'O') continue;
                board[row][col] = 'T';
                q.offer(new int[]{row, col});
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }

    }
}
