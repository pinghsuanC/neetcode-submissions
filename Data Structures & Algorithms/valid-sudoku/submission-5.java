class Solution {
    public boolean isValidSudoku(char[][] board) {
        // loop through the board, check 3 items
        // 1. row
        // 2. column
        // 3. squares

        // first start with 3 seperate loops, later see if can merge
        int N = 9;
        boolean[][] checkRow = new boolean[N][N];
        boolean[][] checkCol = new boolean[N][N];
        boolean[][] checkSquare = new boolean[N][N];

        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                char c = board[row][col];
                if(c == '.') continue;
                if(checkRow[row][c - '1']) return false;
                if(checkCol[col][c - '1']) return false;
                checkRow[row][c - '1'] = true;
                checkCol[col][c - '1'] = true;

                // now check square
                int boxIndex = (row / 3) * 3 + (col / 3);
                if(checkSquare[boxIndex][c - '1']) return false;
                checkSquare[boxIndex][c - '1'] = true;
            }
        }

        return true;
    }
}
