class Solution {
    int[][][] tabula;
    public boolean stoneGame(int[] piles) {
        int total = Arrays.stream(piles).sum();
        tabula = new int[2][piles.length][piles.length];
        for(int[][] arr : tabula){
            for(int[] row : arr) Arrays.fill(row, -1);
        }
        
        int score = helper(piles, 1, 0, piles.length - 1);
        
        return score > total - score;
    }

    // 1 == alice
    public int helper(int[] piles, int player, int l, int r){
        if(l >= r) return 0;
        if(tabula[player][l][r] >= 0) return tabula[player][l][r];

        // which does alice get?
        int numL = piles[l];
        int numR = piles[r];
        int res = -1;
        if(player == 1){
            // alice's turn
            res = Math.max(numL + helper(piles, 1-player, l+1, r), numR + helper(piles, 1-player, l, r-1));
        } else {
            // bob's turn
            res = Math.max(helper(piles, 1-player, l+1, r), helper(piles, 1-player, l, r-1));
        }
        tabula[player][l][r] = res;
        return tabula[player][l][r];
    }
}