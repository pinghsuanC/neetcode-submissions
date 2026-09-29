class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int start = 0, 
            len = 1, 
            n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    int newL = j - i + 1;
                    if(dp[i+1][j-1] == true || newL <= 3){
                        dp[i][j] = true;
                        if(newL > len){
                            len = newL;
                            start = i;                        }
                    }
                }
            }
        }

        return s.substring(start, start + len);
    }
}
