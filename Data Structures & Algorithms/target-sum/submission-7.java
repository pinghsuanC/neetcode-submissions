class Solution {
    int[][] dp;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = 0;
        for(int num : nums) total += num;
        dp = new int[nums.length][total * 2 + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        int res = helper(nums, target, 0, 0);
        
        return res == -1 ? 0 : res;
    }

    private int helper(int[] nums, int target, int sum, int i){
        if(i >= nums.length) return target == sum ? 1 : 0;
        if(dp[i][sum + total] >= 0) return dp[i][sum + total];

        // add
        int add = helper(nums, target, sum + nums[i], i+1);

        // subtract
        int sub = helper(nums, target, sum - nums[i], i+1);
        
        dp[i][sum + total] = add + sub;

        return dp[i][sum + total];
    }

}
