class NumMatrix {
    // intuition: 2D presum
    // expanding the 1D prefix sum solution to use the sum of areas

    int[][] squareSum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        squareSum = new int[row+1][col+1];
        
        for(int i = 0; i < row; i++){
            int prefix = 0;
            for(int j = 0; j < col; j++){
                prefix += matrix[i][j];
                int prev = squareSum[i][j+1];
                squareSum[i+1][j+1] = prev + prefix;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bR = squareSum[row2+1][col2+1];
        int ab = squareSum[row1][col2+1];
        int l = squareSum[row2+1][col1];
        int tL = squareSum[row1][col1];
        return bR - ab - l + tL;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */