class Solution {
    Integer[][][] dp;
    public int stoneGameII(int[] piles) {
        dp = new Integer[2][piles.length][piles.length+1];
        return helper(piles, 1, 0, 1);
    }

    public int helper(int[] piles, int player, int L, int M){
        if(L >= piles.length) return 0;
        if(dp[player][L][M] != null) return dp[player][L][M];

        int res = player == 1 ? 0 : Integer.MAX_VALUE;
        
        int roundTotal = 0;
        for(int X = 1; X <= 2*M; X++){
            if(X + L > piles.length) break;
            roundTotal+=piles[X + L - 1];
            if(player == 1){
                res = Math.max(res, roundTotal + helper(piles, 1-player, L+X, Math.max(M, X)));
            }else{
                res = Math.min(res, helper(piles, 1-player, L+X, Math.max(M, X)));
            }
        }
        dp[player][L][M] = res;
        return res;
    }
}