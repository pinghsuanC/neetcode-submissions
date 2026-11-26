class Solution {

    int[][] tab;
    public int maxProfit(int[] prices) {
        /*
        intuition: DP with state parameters
        -> cooldown parameter
        -> can own only 1 at a time

        */

        tab = new int[2][prices.length];
        for(int[] t : tab) Arrays.fill(t, -1);

        return helper(prices, 0, 1);
    }

    // canBuy = 1 => can buy, 0 => can't buy
    private int helper(int[] prices, int i, int canBuy){
        if(i >= prices.length) return 0;
        if(tab[canBuy][i] >= 0) return tab[canBuy][i];

        // no actions, no buy no sell today
        int res = helper(prices, i+1, canBuy);

        int total = 0;
        // check if canBuy
        if(canBuy == 1){
            // can buy
            total = helper(prices, i+1, 0) - prices[i];

        } else {
            // can't buy, but can sell, can actually buy the next valid day (+2 days)
            total = helper(prices, i+2, 1) + prices[i];
        }

        res = Math.max(res, total);
        tab[canBuy][i] = res;

        return res;
    }
}
