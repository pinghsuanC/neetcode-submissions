class Solution {
    int ans;
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    private int helper(int[] nums, int target, int total, int i){
        if(i == nums.length) {
            return total == target ? 1 : 0;
        }

        return helper(nums, target, total + nums[i], i+1) + helper(nums, target, total - nums[i], i+1);
    }
}
