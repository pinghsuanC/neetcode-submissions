class Solution {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;
        for(int c : coins){
            for(int j = 0; j <= amount; j++){
                if(j < c) continue;
                memo[j] = memo[j - c] + memo[j];
            }
        }
        return memo[amount];
    }

    private int helper(int amount, int[] coins, int i){
        if(amount == 0) return 1;
        if(amount < 0 || i >= coins.length) return 0;

        int res = 0;
        if(coins[i] > amount) return res;
        res += helper(amount - coins[i], coins, i) + helper(amount, coins, i+1);

        return res;
    }
}
