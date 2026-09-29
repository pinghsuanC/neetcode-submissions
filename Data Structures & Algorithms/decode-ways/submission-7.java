class Solution {

    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++) dp[i] = -1;
        dp[s.length()] = 1;
        return helper(s, 0);
    }

    public int helper(String s, int i){
        if(dp[i] >= 0) return dp[i];
        if(s.charAt(i) == '0') return 0;

        int res = helper(s, i+1);
        if(i + 1 < s.length() && 
            (s.charAt(i) == '1' || s.charAt(i) == '2' && 
            s.charAt(i+1) < '7')){
            res += helper(s, i+2);
        }
        dp[i] = res;

        return res;
    }
}
