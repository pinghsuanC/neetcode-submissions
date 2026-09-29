class Solution {
    public int countSubstrings(String s) {
        int count = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(j) == s.charAt(i)){
                    int len = j - i + 1;
                    if(len <= 3 || dp[i+1][j-1] == true){
                        count++;
                        dp[i][j] = true;
                    } 
                }
            }
        }

        return count;
    }
}
