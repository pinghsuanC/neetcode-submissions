class Solution {
    int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Add virtual balloons with value 1
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        dp = new int[n + 2][n + 2];

        return helper(arr, 1, nums.length);
    }

    public int helper(int[] nums, int left, int right){
        if (left > right) return 0;

        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int max = 0;
        for(int i = left; i <= right; i++){
            int coins = 
                helper(nums, left, i-1) 
                + helper(nums, i+1, right)
                + nums[i]* nums[left-1]*nums[right+1];
            max = Math.max(max, coins);
        }
        
        dp[left][right] = max;
        return max;
    }
}
