class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        intuition
        use 2D dp
        define dp[i][j] as the longest subsequence you have in text1[i:j] that you can find in text2
        */
        
        int n1 = text1.length(), n2 = text2.length(), max = 0;
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
