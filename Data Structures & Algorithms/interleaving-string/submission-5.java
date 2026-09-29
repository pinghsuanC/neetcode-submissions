class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        dp = new Boolean[l1 + 1][l2 + 1];

        // # of substrings for s1 and s2, Math.abs(n - m) <= 1
        return helper(s1, s2, s3, 0, 0, 0);

    }

    private boolean helper(String s1, String s2, String s3, int i, int j, int k){
        if(k >= s3.length()) return i == s1.length() && j == s2.length();
        if(dp[i][j] != null) return dp[i][j];

        if(i < s1.length() && s3.charAt(k) == s1.charAt(i)){
            if(helper(s1, s2, s3, i+1, j, k+1)){
                dp[i][j] = true;
                return true;
            }
        } 
        
        if(j < s2.length() && s3.charAt(k) == s2.charAt(j)){
            if(helper(s1, s2, s3, i, j+1, k+1)){
                dp[i][j] = true;
                return true;
            }
        }
        dp[i][j] = false;

        return false;
    }
}
