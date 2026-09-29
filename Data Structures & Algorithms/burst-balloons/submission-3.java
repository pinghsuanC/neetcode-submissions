class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0; i < n; i++) arr[i+1] = nums[i];

        dp = new int[n + 2][n + 2];
        for(int i = 0; i < n+2; i++) Arrays.fill(dp[i], -1);

        return helper(arr, 1, n);
    }

    public int helper(int[] nums, int l, int r){
        if(l > r) return 0;
        if(dp[l][r] >= 0) return dp[l][r];

        dp[l][r] = 0;
        for(int i = l; i <= r; i++){
            int coins = nums[l-1] * nums[i] * nums[r+1];
            coins += helper(nums, l, i-1) + helper(nums, i+1, r);
            dp[l][r] = Math.max(dp[l][r], coins);
        }

        return dp[l][r];
    }
}
