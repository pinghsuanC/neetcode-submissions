class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length, COL = matrix[0].length;
        int l = 0, r = ROW - 1;
        while(l <= r){
            int k = (l + r) / 2;
            if(target < matrix[k][0]){
                r = k - 1;
            } else if (target > matrix[k][COL-1]){
                l = k + 1;
            } else {
                break;
            }
        }

        if(!(l <= r)){
            return false;
        }

        int row = (l + r) / 2;
        l = 0;
        r = COL - 1;
        while(l <= r){
            int k = (l + r) / 2;
            if(target < matrix[row][k]){
                r = k - 1;
            } else if(target > matrix[row][k]){
                l = k + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
