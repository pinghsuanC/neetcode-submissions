class NumMatrix {
    // intuition: use prefix sum for each row
    // then just for each row, sum the matrix[row][col2 - col1];
    // it's O(row2 - row1) so should be a constant, worst case O(matrix rows)

    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        prefixSum = new int[row][col+1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                prefixSum[i][j+1] = matrix[i][j];
                if(j > 0) prefixSum[i][j+1] += prefixSum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            sum += prefixSum[i][col2+1] - prefixSum[i][col1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */