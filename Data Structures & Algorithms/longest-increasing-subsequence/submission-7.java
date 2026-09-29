class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for(int i = n - 1; i >= 0; i--){
            // at each i, either start a new subarray, or continue to build
            // note that dp[i] = the longest subsequence at position i
            
            for(int j = i + 1; j < n; j++){
                if(nums[j] <= nums[i]) continue;
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
