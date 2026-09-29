class Solution {
    Integer[][] dp;
    int max;
    public int findTargetSumWays(int[] nums, int target) {
        max = 0;
        for(int n : nums) max+= n;
        if (Math.abs(target) > max) return 0;

        dp = new Integer[nums.length][max*2+1];
        return helper(nums, target, 0, 0);
    }

    public int helper(int[] nums, int target, int total, int i){
        if(i >= nums.length) return target == total ? 1 : 0;
        if(dp[i][total + max] != null) return dp[i][total + max];

        dp[i][total + max] = helper(nums, target, total + nums[i], i+1) + helper(nums, target, total - nums[i], i+1);

        return dp[i][total + max];
    }
}
