class Solution {
    Map<Integer, Integer> dp;
    public int coinChange(int[] coins, int amount) {
        dp = new HashMap<>();
        int min = helper(coins, amount);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int helper(int[] coins, int amount){
        if(amount == 0) return 0;
        if(dp.containsKey(amount)) return dp.get(amount);

        int res = Integer.MAX_VALUE;
        for(int c : coins){
            if(amount < c) continue;
            int find = helper(coins, amount - c);
            if(find != Integer.MAX_VALUE){
                res = Math.min(res, 1 + find);
            }
        }

        dp.put(amount, res);
        return res;
        
    }
}
