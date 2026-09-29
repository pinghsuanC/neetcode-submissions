class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }
        helper(nums, 0);
        return dp[0];
    }

    public int helper(int[] nums, int i){
        if(i >= nums.length) return 0;
        if(dp[i] >= 0) return dp[i];
        dp[i] = Math.max(helper(nums, i+1), nums[i] + helper(nums, i+2));
        return dp[i];
    }
}
