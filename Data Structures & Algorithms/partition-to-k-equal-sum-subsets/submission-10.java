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

        return helper(nums, new boolean[nums.length], 0, 0);
    }

    public boolean helper(int[] nums, boolean[] taken, int acc, int count){
        if(count == numBucket)  return true;
        
        for(int i = 0; i < nums.length; i++){
            if(taken[i]) continue;
            
            int curVal = acc + nums[i];
            if(curVal > target) continue;
            if(curVal == target){
                // clear up the accumulation and start fresh
                taken[i] = true;
                if(helper(nums, taken, 0, count+1)) return true;
                taken[i] = false;
                return false;
            } else {
                taken[i] = true;
                if(helper(nums, taken, curVal, count)) return true;
                taken[i] = false;
            }
        }
        return false;
    }
}