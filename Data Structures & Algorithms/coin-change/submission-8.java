class Solution {
    Map<Integer, Integer> dp;
    public int coinChange(int[] coins, int amount) {
        dp = new HashMap<>();
        dp.put(0, 0);
        int res = helper(coins, amount);
        return res == (int)1e9 ? -1 : res;
    }

    public int helper(int[] coins, int amount){
        if(dp.containsKey(amount)) return dp.get(amount);

        int res = (int)1e9;
        for(int c : coins){
            if(c > amount) continue;
            res = Math.min(1 + helper(coins, amount - c), res);
        }

        dp.put(amount, res);
        return res;
    }
}
