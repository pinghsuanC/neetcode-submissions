class Solution {
    int[] dp;
    public int numDecodings(String s) {
        // intuition:
        /*
            for each digit at position i
            we can either take it as 1 digit, or 2 digits if if i+1 satisfies certain condition
            with this there is a decision tree
        */
        int n = s.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 1;
        return helper(s, 0);
    }

    private int helper(String s, int i){
        if(dp[i] >= 0) return dp[i];
        if(s.charAt(i) == '0') {
            dp[i] = 0;
            return 0;
        }

        // take 1 digit
        int res = helper(s, i+1);

        // take 2 digits
        if(i + 1 < s.length()){
            if((s.charAt(i) > '0' && s.charAt(i) < '2' && s.charAt(i+1) < '9') ||
                (s.charAt(i) == '2' && s.charAt(i+1) < '7')){
                    res += helper(s, i+2);
                }
        }
        dp[i] = res;

        return res;
    }
}
