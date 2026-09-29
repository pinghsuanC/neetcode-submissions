class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        return Math.max(
            helper(nums, 0, n-1),
            helper(nums, 1, n)
        );
    }

    private int helper(int[] nums, int start, int end){
        int n = nums.length;
        int[] dp = new int[n+2];

        int oneBefore = 0, twoBefore = 0;
        for(int i = end-1; i >= start; i--){
            int cur = Math.max(oneBefore, twoBefore + nums[i]);

            twoBefore = oneBefore;
            oneBefore = cur;
            
            //dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }

        return oneBefore;
    }
}
