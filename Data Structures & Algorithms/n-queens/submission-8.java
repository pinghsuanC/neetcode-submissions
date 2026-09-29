class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(n, 0, board);
        return res;
    }

    public void helper(int n, int i, char[][] board){
        if(i == board.length){
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }
        
        // each row has exactly 1 queen
        for(int m = 0; m < n; m++){
            if(validRow(i, board) && validColumn(m, board) && validDiagnal(i, m, board)){
                board[i][m] = 'Q';
                helper(n, i+1, board);
                board[i][m] = '.';
            }
        }
    }

    private boolean validRow(int row, char[][] board){
        for(int j = 0; j < board.length; j++){
            if(board[row][j] == 'Q') return false;
        }
        return true;
    }

    private boolean validColumn(int col, char[][] board){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 'Q') return false;
        }
        return true;
    }

    private boolean validDiagnal(int checkI, int checkJ, char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(!(Math.abs(checkI - i) == Math.abs(checkJ - j))) continue;
                if(board[i][j] == 'Q') return false;
            }
        }
        return true;
    }

}
