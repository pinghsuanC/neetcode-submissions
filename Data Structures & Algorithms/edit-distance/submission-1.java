class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);

        return helper(word1, word2, 0, 0);
    }

    private int helper(String word1, String word2, int i, int j){
        if(i >= word1.length()) return word2.length() - j;
        if(j >= word2.length()) return word1.length() - i;
        if(dp[i][j] >= 0) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = helper(word1, word2, i+1, j+1);
            return dp[i][j];
        }

        int insert = helper(word1, word2, i, j+1);
        int delete = helper(word1, word2, i+1, j);
        int replace = helper(word1, word2, i+1, j+1);
        dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
        return dp[i][j];
    }
}
