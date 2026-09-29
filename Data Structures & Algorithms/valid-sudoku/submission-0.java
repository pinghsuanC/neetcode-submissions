class Solution {
    public boolean isValidSudoku(char[][] board) {
        int height = 9;
        for(int i = 0; i<height; i++){
            char[] row = board[i];
            char[] col = new char[9];
            for(int j = 0; j<height; j++){
                col[j] = board[j][i];
            }
            if(!isUnique(row)){ return false; }
            if(!isUnique(col)){ return false; }
        }

        // check squares
        for(int k = 0; k<9; k+=3){
            for(int m = 0; m<9; m+=3){
                char[] check = new char[9];
                int count = 0;
                for(int i=k; i<k+3; i++){
                    for(int j = m; j<m+3; j++){
                        check[count] = board[i][j];
                        count++;
                    }
                }
                if(!isUnique(check)){ return false; }
            }

        }

        return true;
    }

    public boolean isUnique(char[] nums){
        HashMap<String, Boolean> check = new HashMap<String, Boolean>();
        for(char c : nums){
            if(c == '.'){ continue; }
            if(check.get(c+"") != null){
                return false;
            }
            check.put(c+"", true);
        }
        return true;
    }
}
