class Solution {
    Map<Integer, Map<Integer, Integer>> dp;
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num : nums) total+= num;
        dp = new HashMap<>();
        /*
        dp = new int[nums.length][total * 2 + 1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        */
        
        return helper(nums, target, 0);
    }

    private int helper(int[] nums, int target, int i){
        if(i >= nums.length) return target == 0 ? 1 : 0;
        if(dp.containsKey(i) && dp.get(i).containsKey(target)) return dp.get(i).get(target);

        // add
        int add = helper(nums, target - nums[i], i+1);

        // subtract
        int sub = helper(nums, target + nums[i], i+1);

        dp.putIfAbsent(i, new HashMap<Integer, Integer>());
        dp.get(i).putIfAbsent(target, 0);
        dp.get(i).put(target, add + sub);

        return dp.get(i).get(target);
    }
}
