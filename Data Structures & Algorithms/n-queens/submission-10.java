class Solution {
    List<List<String>> res;
    List<List<Integer>> columns;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        columns = new ArrayList<>();
        helper(n, 0, new ArrayList<int[]>());
        return res;
    }

    public void helper(int n, int i, List<int[]> points){
        if(i >= n){
            // create the answer here
            List<String> board = new ArrayList<>();
            for(int[] point : points){
                String line = "";
                for(int k = 0; k < n; k++){
                    if(k == point[1]){
                        line+="Q";
                    } else {
                        line+=".";
                    }
                }
                board.add(line);
            }
            res.add(board);
            return;
        }

        for(int j = 0; j < n; j++){
            boolean isValid = true;
            for(int[] point : points){
                if(!isValid(i, j, point[0], point[1])){
                    isValid = false;
                    break;
                }
            }
            if(!isValid) continue;

            // a valid point found, use backtracking
            points.add(new int[]{i, j});
            helper(n, i+1, points);
            points.remove(points.size() - 1);
        }
    }

    private boolean isValid(int i1, int j1, int i2, int j2){
        if(j1 == j2 || i1 == i2) return false;
        if(Math.abs(j1 - j2) == Math.abs(i1 - i2)) return false;

        return true;
    }
}
