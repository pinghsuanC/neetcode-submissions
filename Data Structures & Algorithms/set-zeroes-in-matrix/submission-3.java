class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = false;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    // set the first row / column to 0
                    
                    if(i > 0){
                        matrix[i][0] = 0;
                    } else {
                        rowZero = true;
                    }
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int r = 0; r < m; r++) matrix[r][0] = 0;
        }

        if(rowZero){
            for(int c = 0; c < n; c++) matrix[0][c] = 0;
        }

        
    }
}
