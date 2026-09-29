class Solution {
    int[][] directions = new int[][]{
        {1, 0}, {0, 1}
    };

    int[][] memo;
    
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = -1;
            }
        }
        return helper(m, n, 0, 0);
    }

    public int helper(int m, int n, int i, int j){
        if(i >= m || i < 0 || j >= n || j < 0) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        if(memo[i][j] >= 0) return memo[i][j];
        
        int res = 0;
        for(int[] dir : directions) res+=helper(m, n, i + dir[0], j + dir[1]);
        memo[i][j] = res;

        return res;
    }
}
