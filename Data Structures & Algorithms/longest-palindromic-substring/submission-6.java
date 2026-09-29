class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[n][n];
        // int i, j = if the string i->j is a palindrom

        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                int len = j - i + 1;
                if(s.charAt(i)==s.charAt(j)){
                    if((dp[i+1][j-1] == true) || len <= 3){
                        dp[i][j] = true;
                        if(len > maxLen){
                            maxLen = len;
                            start = i;
                        }
                    }
                }
                
            }
        }

        return s.substring(start, start+maxLen);
    }
}
