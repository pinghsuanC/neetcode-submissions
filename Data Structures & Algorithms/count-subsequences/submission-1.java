class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[t.length()][s.length()];
        for(int[] tmp : dp) Arrays.fill(tmp, -1);
        return helper(s, t, 0, 0);
    }

    public int helper(String s, String t, int i, int j){
        if(i >= t.length()) return 1;
        if(j >= s.length()) return 0;
        if(dp[i][j] > -1) return dp[i][j];

        if(s.charAt(j) == t.charAt(i)){
            dp[i][j] = helper(s, t, i+1, j+1) + helper(s, t, i, j+1);
        } else {
            dp[i][j] = helper(s, t, i, j+1);
        }
        
        return dp[i][j];
    }
}
