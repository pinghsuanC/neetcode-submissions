class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dp = new int[m+1][n+1];
        for(int[] p : dp) Arrays.fill(p, -1);

        return helper(word1, word2, 0, 0, m, n);
    }

    private int helper(String word1, String word2, int i, int j, int len1, int len2){
        if(i >= len1) return len2 - j; // ?
        if(j >= len2) return len1 - i; // ?
        if(dp[i][j] >= 0) return dp[i][j];

        // if two chars are equal, no need to do anything, move to the next step
        int res = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = helper(word1, word2, i+1, j+1, len1, len2);
        } else {
            // else we have 3 operations
            int add = helper(word1, word2, i+1, j,len1, len2);
            int delete = helper(word1, word2, i, j+1,len1, len2);
            int change = helper(word1, word2, i+1, j+1,len1, len2);

            res = Math.min(add, Math.min(delete, change));
            dp[i][j] = res + 1;
        }
        
        return dp[i][j];
    }
}
