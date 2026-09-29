class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1); // all lengths start at 1 number
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(nums[j] <= nums[i]) continue;
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
