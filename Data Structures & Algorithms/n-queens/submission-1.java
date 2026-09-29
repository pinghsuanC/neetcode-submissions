class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(n, 0, 0, 0, board);

        return res;
    }

    public void helper(int n, int i, int j, int count, char[][] board){
        if(i == board.length){
            if(count < n) return;
            List<String> tmp = new ArrayList<>();
            for(int p = 0; p < board.length; p++){
                String row = "";
                for(int q = 0; q < board.length; q++){
                    if(board[p][q] != 'Q'){
                        row+=".";
                    } else{
                        row+="Q";
                    }
                }
                tmp.add(row);
            }
            res.add(tmp);
            return;
        }
        
        // each row has exactly 1 queen
        for(int k = i; k < n; k++){
            for(int m = j; m < n; m++){
                if(validRow(k, board) && validColumn(m, board) && validDiagnal(k, m, board)){
                    board[k][m] = 'Q';
                    helper(n, k+1, 0, count+1, board);
                    board[k][m] = '.';
                }
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
        // otpimize later
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(!(Math.abs(checkI - i) == Math.abs(checkJ - j))) continue;
                if(board[i][j] == 'Q') return false;
            }
        }
        return true;
    }

}
