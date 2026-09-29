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

        char c = t.charAt(i);
        int count = 0;
        for(int k = j; k < s.length(); k++){
            if(s.charAt(k) == c){
                count += helper(s, t, i+1, k+1);
            } 
        }
        dp[i][j] = count;
        return dp[i][j];
    }
}
