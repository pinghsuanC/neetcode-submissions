class Solution {
    public int lengthOfLIS(int[] nums) {
        // brute force
        int res = 1;
        int[] dp = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) dp[i] = 1;

        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        for(int i = dp.length - 1; i >= 0; i--){
            System.out.print(dp[i] + " ");
        }

        return res;
    }

}
