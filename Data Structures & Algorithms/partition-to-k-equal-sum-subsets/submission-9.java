class Solution {
    boolean res;
    int bucketNum;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        if(total % k != 0) return false;
        

        res = false;
        bucketNum = k;
        int target = total / k; // the target amount of each bucket

        for(int n : nums){
            if(n > target) return false;
        }
        
        Arrays.sort(nums);
        boolean[] taken = new boolean[nums.length];
        helper(nums, target, taken, 0, 0);
        return res;
    }

    private void helper(int[] nums, int target, boolean[] taken, int bucket, int acc){
        if(acc == bucketNum){
            res = true;
            return;
        }
        if(res) return;

        for(int j = 0; j < nums.length; j++){
            if(taken[j]) continue;
            if (j > 0 && nums[j] == nums[j - 1] && !taken[j - 1]) continue;

            int newBucket = bucket + nums[j];
            if(newBucket > target) return; // plurge, can't bag this one & anyone that follows cause' sorted
            // take
            if(newBucket == target){
                taken[j] = true;
                // reset the bucket to 0
                helper(nums, target, taken, 0, acc+1);
                taken[j] = false;
            } else {
                // find the next item to grab
                taken[j] = true;
                helper(nums, target, taken, newBucket, acc);
                taken[j] = false;
            }
        }

    }
}