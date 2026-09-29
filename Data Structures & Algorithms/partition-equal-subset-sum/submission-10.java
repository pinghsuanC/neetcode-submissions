class Solution {
    public boolean canPartition(int[] nums) {
        /*
        notes

        want 2 subsets of equal sum
        meaning total = 2 * sum(subset)
        -> it has to be even, else it's not possible

        Then the problem becomes whether you can create sum(subset) with elemetns in num
        -> if you can create one, the other one follows
        
        */

        int total = 0, n = nums.length;
        for(int num : nums) total += num;
        if(total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num : nums){
            for(int t = target; t >= 0; t--){
                if(t < num) continue;
                if(dp[t] == true) break;
                dp[t] = dp[t - num];
            }
        }

        return dp[target];
    }
}
