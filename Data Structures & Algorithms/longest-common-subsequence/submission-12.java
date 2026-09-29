class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        intuition

        for each of the position i, j for text1 and text2 correspondingly
        we want to know the LCS for text1[i:] and text2[j:]
        until the entire string

        text1 = "cat", text2 = "crabt"

        e.g. 
        
        at the end positions， i = m - 1, j = n - 1
        text1[m - 1] = 't', text2[n - 1] = 't'
        same letter, add it to LCS

        at the end-1 positions, i = m - 2, j = n - 2
        text1[m - 2] = 'a', text2[n - 2] = 'b'
        doesn't match
        then LCS at end - 1 = LCS in the above case (1), because LCS doesn't change if there is no match
        
        move j forward, i = m - 3, j = n - 3
        text1[i] = 'a', text2[j] = 'a'
        we have a match, 1 + previous position


        notice that we need to traverse all the conditions for i and j
        */ 


        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];

    }
}
