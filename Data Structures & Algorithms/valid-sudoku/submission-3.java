class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] checkRow = new boolean[9][9];
        boolean[][] checkColumn = new boolean[9][9];
        boolean[][] checkBox = new boolean[9][9];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue; 
                int val = board[i][j] - '0' - 1;
                // check column
                if(checkColumn[j][val] == true) return false;
                checkColumn[j][val] = true;

                // check row
                if(checkRow[i][val] == true) return false;
                checkRow[i][val] = true;

                // check matrix
                int index = (i/3) * 3 + j/3;
                if(checkBox[index][val] == true) return false;
                checkBox[index][val] = true;
            }
        }

        return true;
    }
}
