class Solution {

    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] m : memo) Arrays.fill(m, -1);

        return helper(text1, text2, 0, 0);
    }

    private int helper(String s1, String s2, int i, int j){
        if(i >= s1.length() || j >= s2.length()) return 0;
        if(memo[i][j] >= 0) return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            int res = 1 + helper(s1, s2, i+1, j+1);
            memo[i][j] = res;
            return res;
        }

        memo[i][j] = Math.max(helper(s1, s2, i+1, j), helper(s1, s2, i, j+1));
        return memo[i][j];
    }
}
