class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[s.length()] = 1;
        return dfs(s, 0);
    }

    public int dfs(String s, int i){
        
        if(dp[i] >= 0) return dp[i]; // This is also the base case since we defaulted dp[s.length()]  to 1.
        if(s.charAt(i) == '0') return 0;

        int res = dfs(s, i + 1);
        if(i + 1 < s.length()){
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'){
                res += dfs(s, i+2);
            }
        }
        dp[i] = res;
        return res;
    }
}
