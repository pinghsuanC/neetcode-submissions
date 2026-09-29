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

        int flag = ((robFirst == 1) || (i == 0)) == true ? 1 : 0;
        dp[i][robFirst] = Math.max(helper(nums, i+1, robFirst), nums[i] + helper(nums, i+2, flag));

        return dp[i][robFirst];
    }
}
