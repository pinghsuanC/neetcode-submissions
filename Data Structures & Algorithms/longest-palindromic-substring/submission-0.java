class Solution {
    public String longestPalindrome(String s) {
        // intuition: create a matrix of s.length x s.length
        // first index indicates l, right index indicates r
        // matrix[i][j] stores wether i to j is a palindrome
        // when we are at i, j. check if matrix[i+1][j-1] has been calculated
        // if so we just need to calculate the outermost indices i and j, and store the outcome
        int n = s.length();
        int maxI = 0;
        int maxJ = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2 || dp[i+1][j-1]){
                        dp[i][j] = true;
                        if(maxJ - maxI < j - i){
                            maxJ = j;
                            maxI = i;
                        }
                    }
                }
            }
        }
        return s.substring(maxI, maxI + (maxJ - maxI + 1));
    }
}
