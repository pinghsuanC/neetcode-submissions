class Solution {
    private int[][][] dp;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[2][n][n+1];
        for(int[][] layer : dp){
            for(int[] row : layer) Arrays.fill(row, -1);
        }
 
        return helper(piles, 1, 0, 1);
    }

    // 1 == alice, 2 == bob
    public int helper(int[] piles, int player, int left, int M){
        if(left >= piles.length) return 0;
        if(dp[player][left][M] != -1) return dp[player][left][M];

        int sumRound = 0;
        int max = player == 1 ? 0 : Integer.MAX_VALUE;
        
        for(int X = 1; X <= 2*M; X++){
            if(left + X > piles.length) break;
            sumRound+=piles[left+X-1]; 

            int next = helper(piles, 1 - player, left + X, Math.max(M, X));

            if (player == 1) {
                max = Math.max(max, sumRound + next);
            } else {
                max = Math.min(max, next);
            }
        }

        dp[player][left][M] = max;
        return max;
    }
}