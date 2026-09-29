class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0; i < nums.length; i++) arr[i+1] = nums[i];

        dp = new int[n+2][n+2];
        for(int[] d : dp) Arrays.fill(d, -1);

        return helper(arr, 1, n);
    }

    public int helper(int[] nums, int left, int right){
        if(left > right) return 0;
        if(dp[left][right] >= 0) return dp[left][right];

        int max = 0;
        for(int i = left; i <= right; i++){
            int total = nums[i] * nums[left-1] * nums[right+1];
            total += helper(nums, i+1, right) + helper(nums, left, i-1);
            max = Math.max(max, total);
        }
        dp[left][right] = max;

        return max;
    }
}
