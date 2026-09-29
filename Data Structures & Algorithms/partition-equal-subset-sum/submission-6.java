class Solution {
    public boolean canPartition(int[] nums) {
        // intuition:
        // inorder to have equal sum, we have to have an even number (/2)
        // the rest is to find if we have a combination in nums taht can sum up to (total /2)

        int total = 0, n = nums.length;
        for(int num : nums) total += num;
        if(total % 2 != 0) return false;
        
        int target = total / 2;
        boolean[][] dp = new boolean[n + 1][total + 1];

        for(int i = 0; i <= n; i++) dp[i][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                if(j < nums[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
           }
        }
        

        return dp[n][target];
    }

    private boolean helper(int[] nums, int i, int target){
        if(target == 0 && i < nums.length) return true;
        if(i >= nums.length) return false;

        boolean res = false;
        for(int j = i; j < nums.length; j++){
            if(nums[j] > target) continue;
            res = res || helper(nums, j+1, target - nums[j]);
        }

        return res;
    }


}
