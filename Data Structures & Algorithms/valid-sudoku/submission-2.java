class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowSets = new ArrayList<>(9);
        List<Set<Character>> colSets = new ArrayList<>(9);
        List<Set<Character>> squares = new ArrayList<>(9);

        for(int i = 0; i < 9; i++){
            rowSets.add(new HashSet<Character>());
            colSets.add(new HashSet<Character>());
            squares.add(new HashSet<Character>());
        }
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char val = board[i][j];
                if('.' == val){
                    continue;
                }
                
                // check for row
                if(rowSets.get(j).contains(val)){
                    return false;
                }
                rowSets.get(j).add(val);
                
                // check for col
                if(colSets.get(i).contains(val)){
                    return false;
                }
                colSets.get(i).add(val);

                // check for square
                int code = i/3 * 3 + j/3;
                if(squares.get(code).contains(val)){
                    return false;
                }
                squares.get(code).add(val);
            }
        }

        return true;
    }
}
