class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 2][p.length() + 2];

        return helper(s, p, 0, 0);
    }

    public boolean helper(String s, String p, int i, int j){
        if(j >= p.length()) return i == s.length();
        if(dp[i][j] != null) return dp[i][j];

        boolean firstMatch = i < s.length() && 
            (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

        boolean res = false;
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            // matches 0
            res |= helper(s, p, i, j+2);

            // matches more than 0 if the first matches (stay at j and move i only
            if(firstMatch){
                res |= helper(s, p, i+1, j);
            }
        } else {
            res |= firstMatch && helper(s, p, i+1, j+1);
        }
        dp[i][j] = res;

        return res;
    }
}
