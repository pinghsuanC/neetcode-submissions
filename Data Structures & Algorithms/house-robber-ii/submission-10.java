class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length + 1][2];
        for(int[] d : dp) Arrays.fill(d, -1);

        return Math.max(helper(nums, 0, 1), helper(nums, 0, 0));
    }

    private int helper(int[] nums, int i, int robFirst){
        if(i == nums.length - 1 && robFirst == 1 || i >= nums.length) return 0;
        if(dp[i][robFirst] >= 0) return dp[i][robFirst];

        dp[i][robFirst] = Math.max(helper(nums, i+1, robFirst), nums[i] + helper(nums, i+2, robFirst | (i==0 ? 1:0)));

        return dp[i][robFirst];
    }
}
