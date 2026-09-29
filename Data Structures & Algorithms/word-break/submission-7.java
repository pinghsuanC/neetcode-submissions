class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i = n-1; i >= 0; i--){
            for(String w : wordDict){
                if((i + w.length()) > n) continue;
                if(dp[i]) break; // already confirmed string at position i to the end is going to be segmentable
                if(s.substring(i, i+w.length()).equals(w)){
                    dp[i] = dp[i+w.length()];
                }
            }
        }
        return dp[0];

    }
}
