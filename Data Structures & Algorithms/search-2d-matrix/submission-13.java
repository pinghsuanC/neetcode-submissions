class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROLS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = (ROLS * COLS) - 1;
        while(l <= r){
            int m = (l + r) / 2;
            int row = m / COLS, col = m % COLS;
            int val = matrix[row][col];
            if(target == val){ 
                return true;
            }else if(target < val){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return false;
    }
}
