class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for(int i = n - 2; i >= 0; i--){
            // at each position i, what's the longest increasing sequence we can have?
            for(int j = i+1; j < n; j++){
                if(nums[j] <= nums[i]) continue;
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
