class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        
        res = new ArrayList<>();

        helper(n, 0, new ArrayList<int[]>());

        return res;
    }

    // find the points to put Queue
    public void helper(int n, int row, List<int[]> points){
        if(row >= n){
            // create the board
            res.add(drawBoard(n, points));
            return;
        }

        for(int col = 0; col < n; col++){
            int[] cur = new int[]{row, col};
            if(isValid(cur, points)){
                points.add(cur);
                helper(n, row+1, points);
                points.remove(points.size() - 1);
            }
        }
    }

    // check validity of the points
    private boolean isValid(int[] pt1, List<int[]> points){
        for(int[] pt2 : points){
            if(pt1[0] == pt2[0] || pt1[1] == pt2[1]) return false;
            if(Math.abs(pt1[0] - pt2[0]) == Math.abs(pt1[1] - pt2[1])) return false;
        }
        
        return true;
    }

    // construct the board and save to answer
    private List<String> drawBoard(int n, List<int[]> points){
        List<String> res = new ArrayList<>();
        for(int[] pt : points){
            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[pt[1]] = 'Q';
            res.add(new String(line));
        }
        return res;
    }
}
