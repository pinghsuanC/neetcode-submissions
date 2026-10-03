class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        dp = new int[Math.max(target+1, sum+1)];
        Arrays.fill(dp, -1);
        return helper(nums, target, 0);
    }

    public int helper(int[] nums, int target, int acc){
        if(acc == target) return 1;
        if(dp[acc] >= 0) return dp[acc];

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(acc + nums[i] > target) continue;
            res += helper(nums, target, acc+nums[i]);
        }
        dp[acc] = res;

        return res;
    }
}