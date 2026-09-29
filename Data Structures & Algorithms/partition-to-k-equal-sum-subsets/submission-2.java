class Solution {
    int target;
    int numBucket;
    boolean ans;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        /*
        intuition:
        since we want k equal sums, calculate the target first
        and backtrack to find if the partition is possible
        */

        int total = Arrays.stream(nums).sum();
        if(total % k != 0) return false;
        target = total / k;
        for(int n : nums){
            if(n > target) return false;
        }
        
        numBucket = k;
        ans = false;

        Arrays.sort(nums);

        helper(nums, new boolean[nums.length], 0, 0);

        return ans;
    }

    public void helper(int[] nums, boolean[] taken, int acc, int count){
        if(count == numBucket) {
            ans = true;
            return;
        }
        
        if(ans) return;
        for(int i = 0; i < nums.length; i++){
            if(taken[i]) continue;
            
            int curVal = acc + nums[i];
            if(curVal > target) continue;
            if(curVal == target){
                // clear up the accumulation and start fresh
                taken[i] = true;
                helper(nums, taken, 0, count+1);
                taken[i] = false;
                return;
            }

            taken[i] = true;
            helper(nums, taken, curVal, count);
            taken[i] = false;
        }
    }
}