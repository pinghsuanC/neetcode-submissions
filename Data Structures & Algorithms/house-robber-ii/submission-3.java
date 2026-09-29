class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        return Math.max(
            helper(Arrays.copyOfRange(nums, 0, n-1)),
            helper(Arrays.copyOfRange(nums, 1, n))
        );
    }

    private int helper(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+2];

        for(int i = n-1; i >= 0; i--){
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }

        return dp[0];
    }
}
