class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()][word2.length()];
        return helper(word1, word2, 0, 0);
    }

    public int helper(String s1, String s2, int i, int j){
        // if i reaches the end, whatever comes after s2 needs an insertion
        if(i == s1.length()) return s2.length() - j;
        // if j reaches the end of s2, whatever comes after i needs a deletion
        if(j == s2.length()) return s1.length() - i;
        if(dp[i][j] != null) return dp[i][j];

        int res = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = helper(s1, s2, i+1, j+1);
            return dp[i][j];
        }

        int insert = helper(s1, s2, i, j+1);
        int delete = helper(s1, s2, i+1, j);
        int replace = helper(s1, s2, i+1, j+1);

        res = 1 + Math.min(insert, Math.min(delete, replace));
        dp[i][j] = res;
        return res;
    }
}
