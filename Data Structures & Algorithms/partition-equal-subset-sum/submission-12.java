class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if(total % 2 != 0) return false;

        int target = total / 2;
        memo = new Boolean[nums.length][target+1];

        return helper(nums, target, 0, 0);
    }

    public boolean helper(int[] nums, int target, int i, int acc){
        if(i >= nums.length) return target == acc;
        if(memo[i][acc] != null) return memo[i][acc];
        
        // skip current
        boolean skip = helper(nums, target, i+1, acc);

        // take current
        boolean take = false;
        if(acc + nums[i] <= target){
            take = helper(nums, target, i+1, acc + nums[i]);
        }

        memo[i][acc] = skip || take;
        return memo[i][acc];
    }
}
