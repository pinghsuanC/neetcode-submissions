class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        dp = new int[Math.max(target+1, sum+1)];
        Arrays.sort(nums);
        dp[target] = 1;

        int res = 0;
        for(int acc = target; acc >= 0; acc--){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > acc) break;
                dp[acc - nums[i]] = dp[acc] + dp[acc - nums[i]];
            }
        }

        return dp[0];
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