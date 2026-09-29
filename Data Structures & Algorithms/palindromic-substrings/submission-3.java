class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i + 1 <= 3 || dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }

        return count;

    }
}
