class Solution {
     private int[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[2][n][n + 1];
        for (int[][] arr : dp) {
            for (int[] row : arr) Arrays.fill(row, -1);
        }
        return helper(piles, 1, 0, 1);
    }

    public int helper(int[] piles, int player, int i, int M){
        if(i >= piles.length) return 0;
        if (dp[player][i][M] != -1) return dp[player][i][M];

        int max = player == 1 ? 0 : Integer.MAX_VALUE;
        int roundTotal = 0;

        for(int X = 1; X <= 2*M; X++){
            if(i + X > piles.length) break;
            roundTotal += piles[i + X - 1];
            if(player == 1){
                // alice tries to maximize what she gets
                max = Math.max(max, roundTotal + helper(piles, 0, i + X, Math.max(M, X)));
            } else {
                // bob tries to minimize what alice can get
                max = Math.min(max, helper(piles, 1, i + X, Math.max(M, X)));
            }
        }
        dp[player][i][M] = max;

        return max;
    }
}