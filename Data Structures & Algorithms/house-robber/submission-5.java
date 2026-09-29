class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        for(int i = 0; i < nums.length + 1; i++) dp[i] = -1;
        return helper(nums, 0);
    }

    private int helper(int[] nums, int i){
        if(i >= nums.length) return 0;
        if(dp[i] >= 0) return dp[i];
        int route1 = nums[i] + helper(nums, i+2);
        int route2 = helper(nums, i+1);
        dp[i] = Math.max(route1, route2);
        return dp[i];
    }
}
