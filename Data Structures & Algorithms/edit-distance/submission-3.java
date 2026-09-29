class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        // initiate dp array & base cases
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n; i++) dp[i][m] = n - i;
        for(int j = 0; j < m; j++) dp[n][j] = m - j;

        // build from bottom
        // go from n-1 to 0 because we need i+1 and j+1 calculated
        for(int i = n-1; i >= 0; i--){
            for(int j =m-1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    int insert = dp[i][j+1];
                    int delete = dp[i+1][j];
                    int replace = dp[i+1][j+1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
                }
            }
        }

        return dp[0][0];
    }

    private int helper(String s1, String s2, int i, int j){
        if(i >= s1.length()) return s2.length() - j;
        if(j >= s2.length()) return s1.length() - i;

        if(s1.charAt(i) == s2.charAt(j)){
            return helper(s1, s2, i+1, j+1);
        } else {
            int insert = helper(s1, s2, i, j+1);
            int delete = helper(s1, s2, i+1, j);
            int replace = helper(s1, s2, i+1, j+1);

            return Math.min(insert, Math.min(delete, replace)) + 1;
        }
    }
}
