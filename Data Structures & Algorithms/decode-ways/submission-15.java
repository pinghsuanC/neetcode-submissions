class Solution {
    public int numDecodings(String s) {
        /*
            intuition:
            dp[i] = # ways to decode at i
            let's say 51216
            at 6 (index = 4) we have 1 way to decode 1
            at 1 (index = 3) we have 2 ways to decode 16
                -> 1 + 6
                -> 16 (1 is below 2 and 6 is below 7)
            at 2 (index = 2), we have ? ways?
                -> 2 + 1 + 6
                -> 2 + 16
                -> 21 + 6
            -> Observe that it's by checking (1) 2 as a solitude (2) 2 as a 2-digit group
            -> notice that when we treat 2 as a solitude number, # ways 216 can be deocded = # ways 16 can be decoded
            -> there fore total # = #(16) + #(6)
            the ith number doesn't really matter, the answer depends on what tail it has 
        */

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = 1;

        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }

            dp[i] = dp[i + 1];
            if(i + 1 < n){
                if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'){
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
