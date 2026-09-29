class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        for(int i = 0; i < nums.length; i++) memo[i] = -1;
        return helper(nums, 0);
    }

    public int helper(int[] nums, int i){
        if(i >= nums.length) return 0;
        if(memo[i] >= 0) return memo[i];
        memo[i] = Math.max(nums[i] + helper(nums, i+2), helper(nums, i+1));
        return memo[i];
    }
}
