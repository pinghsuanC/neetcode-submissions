class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() + 1][text2.length() + 1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return helper(text1, text2, 0, 0);
    }

    private int helper(String text1, String text2, int i, int j){
        if(i >= text1.length() || j >= text2.length()) return 0;
        if(dp[i][j] >= 0) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + helper(text1, text2, i+1, j+1);
            return dp[i][j];
        }

        dp[i][j] = Math.max(helper(text1, text2, i+1, j), helper(text1, text2, i, j+1));
    
        return dp[i][j];
    }
}
