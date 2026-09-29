class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        while(matrix[row][0] > target && row > 0){
            row = row / 2;
        }

        int nextRow = row + 1;
        while(row < matrix.length && nextRow < matrix.length 
                && matrix[nextRow][0] < target){
            row++;
            nextRow = row+1;
        }

        if(matrix[row][0] == target){
            return true;
        } else {
            for(int i = 0; i<matrix[row].length; i++){
                if(matrix[row][i] == target){
                    return true;
                }
            }
        }

        return false;
    }
}
