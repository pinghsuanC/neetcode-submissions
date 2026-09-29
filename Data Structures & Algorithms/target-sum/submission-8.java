class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0, n = nums.length;
        for(int num : nums) total += num;
        if (Math.abs(target) > total) return 0;

        int[][] dp = new int[n + 1][total * 2 + 1];
        dp[0][total] = 1;
        
        for(int i = 0; i < n; i++){
            for (int sum = -total; sum <= total; sum++) {
                int ways = dp[i][sum + total];
                if (ways == 0) continue;
                dp[i + 1][sum + nums[i] + total] += ways;
                dp[i + 1][sum - nums[i] + total] += ways;
            }
        }

        return dp[nums.length][target + total];
    }



/*
    private int helper(int[] nums, int target, int sum, int i){
        if(i >= nums.length) return target == sum ? 1 : 0;
        if(dp[i][sum + total] >= 0) return dp[i][sum + total];
        
        dp[i][sum + total] = helper(nums, target, sum + nums[i], i+1) + 
                                helper(nums, target, sum - nums[i], i+1);

        return dp[i][sum + total];
    }
    */
}
