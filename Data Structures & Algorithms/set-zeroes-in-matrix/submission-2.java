class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) {
                    update(matrix, i, j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }

    public void update(int[][] matrix, int i, int j){
        int m = matrix.length, n = matrix[0].length;
        
        for(int k = i; k < m; k++){
            if(matrix[k][j] != 0) matrix[k][j] = -1;
        }
        for(int k = 0; k < i; k++){
            if(matrix[k][j] != 0) matrix[k][j] = -1;
        }
        for(int k = j; k < n; k++){
            if(matrix[i][k] != 0) matrix[i][k] = -1;
        }
        for(int k = 0; k < j; k++){
            if(matrix[i][k] != 0) matrix[i][k] = -1;
        }
    }
}
