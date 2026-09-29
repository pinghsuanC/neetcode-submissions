class Solution {
    boolean[][] dp;
    public boolean canPartition(int[] nums) {
        /* intuition: since two branckets need to have the same sum, then it has to be even.
        If total amount is odd, it's impossible.

        and our target sum for one bucket is determined by / 2.

        In recursion, for each number, there are 2 decision: to take or not to take
        
        */
        int total = 0, n = nums.length;
        for(int num : nums) total+=num;
        if(total % 2 != 0) return false;
        dp = new boolean[n][total + 1];
        return helper(nums, 0, total / 2);
    }

    private boolean helper(int[] nums, int i, int target){
        if(target < 0) return false;
        if(i == nums.length){
            if(target == 0) return true;
            return false;
        }
        if(dp[i][target]) return true;
        

        boolean res = helper(nums, i+1, target-nums[i]) || helper(nums, i+1, target);
        dp[i][target] = res;
        return res;
    }
}
