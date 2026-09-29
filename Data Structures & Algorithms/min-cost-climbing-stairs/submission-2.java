class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        int res = Math.min(helper(cost, 0), helper(cost, 1));
        return res;
    }

    public int helper(int[] cost, int i){
        if(i >= cost.length) return 0;
        if(memo[i] > 0) return memo[i];
        memo[i] = cost[i] + Math.min(helper(cost, i+1), helper(cost, i+2));
        return memo[i];
    }
}
