class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2) return s;

        boolean[][] dp = new boolean[n][n];
        int maxI = Integer.MIN_VALUE, maxLen = 0;
        

        for(int i = n; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i == j ||
                        dp[i+1][j-1] == true || 
                        (j - i + 1 <= 3)){
                         dp[i][j] = true;
                         if(j - i + 1 > maxLen){
                            maxLen = j - i + 1;
                            maxI = i;
                         } 
                    }
                }
            }
        }

        return s.substring(maxI, maxI + maxLen);
    }
}
