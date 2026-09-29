class Solution {
    boolean ans;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] arr = word.toCharArray();
        boolean[][] taken = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == arr[0]){
                    helper(board, i, j, 0, taken, arr);
                }
            }
        }
        return ans;
    }

    public void helper(char[][] board, int i, int j, int target, boolean[][] taken, char[]arr){
        if(target >= arr.length){
            ans = true;
            return;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        
        if(board[i][j] == arr[target] && taken[i][j] == false){
            taken[i][j] = true;
            System.out.println(board[i][j]);
            helper(board, i+1, j, target+1, taken, arr);
            helper(board, i-1, j, target+1, taken, arr);
            helper(board, i, j+1, target+1, taken, arr);
            helper(board, i, j-1, target+1, taken, arr);
            taken[i][j] = false;
            //helper(board, i+1, j, target, taken, arr);
            //helper(board, i-1, j, target, taken, arr);
            //helper(board, i, j-1, target, taken, arr);
            //helper(board, i, j+1, target, taken, arr);
        }
        
    };
}
