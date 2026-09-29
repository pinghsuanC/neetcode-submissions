class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
            helper(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }

    private int helper(int[] nums){
        if(nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
