class Solution {
    int res;
    public int totalNQueens(int n) {
        /*
        intuition:
        just n-queens, but instead of prints, now it wants count of distinct solutions
        to get distinct, do a filter at the end on the positions. or use map or set, use index as keys        
        */
        res = 0;
        helper(n, 0, new ArrayList<>());

        return res;
    }


    public void helper(int n, int row, List<int[]> positions){
        if(row >= n) {
            res++;
            return;
        }

        for(int col = 0; col < n; col++){
            int[] cur = new int[]{row, col};
            if(!helper(cur, positions)) continue;
            positions.add(cur);
            helper(n, row + 1, positions);
            positions.remove(positions.size() - 1);
        }
    }

    private boolean helper(int[] point, List<int[]> existing){
        for(int[] k : existing){
            if(point[0] == k[0] || point[1] == k[1]) return false;
            if(Math.abs(point[0] - k[0]) == Math.abs(point[1] - k[1])) return false;
        }
        return true;
    }
}