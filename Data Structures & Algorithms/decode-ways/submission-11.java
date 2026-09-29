class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp1 = 1;
        int dp2 = 0;
        int dp = 0;

        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                dp = 0;
            } else {
                dp = dp1;
                if(i + 1 < n){
                    if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'){
                        dp += dp2;
                    }
                }
            }

            dp2 = dp1;
            dp1 = dp;
            dp = 0;
        }

        return dp1;
    }
}
