class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Integer>> rowSets = new HashMap<>();
        Map<String, Set<Integer>> colSets = new HashMap<>();
        Map<String, Set<Integer>> squares = new HashMap<>();
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int val = board[i][j];
                if('.' == val){
                    continue;
                }
                
                // check for row
                rowSets.putIfAbsent(""+j, new HashSet<Integer>());
                if(rowSets.get(""+j).contains(val)){
                    return false;
                }
                rowSets.get(j+"").add(val);
                
                // check for col
                colSets.putIfAbsent(""+i, new HashSet<Integer>());
                if(colSets.get(""+i).contains(val)){
                    return false;
                }
                colSets.get(i+"").add(val);

                // check for square
                String code = i/3 + "-" + j/3;
                squares.putIfAbsent(code, new HashSet<Integer>());
                if(squares.get(code).contains(val)){
                    return false;
                }
                squares.get(code).add(val);
            }
        }

        return true;
    }
}
