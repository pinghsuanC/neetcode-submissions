class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        notes

        dp[i] = if word s[i:] can be processed int segments in wordDict

        */
        
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        
        for(int i = n - 1; i >= 0; i--){
            for(String w : wordDict){
                int len = w.length();
                // skip the words that's gonna exceed the end of the string
                if(i + len > n) continue;

                if(w.equals(s.substring(i, i + len))){
                    dp[i] = dp[i] || dp[i + len];
                }
            }
        }

        return dp[0];
    }
}
