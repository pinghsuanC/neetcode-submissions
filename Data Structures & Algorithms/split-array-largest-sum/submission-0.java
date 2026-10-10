class Solution {
    Integer[][] memo;
    public int splitArray(int[] nums, int k) {
        /*
        1. k subarray
        2. minimize max sum
        3. return the min largest sum

        thoughts
        -> create prefixsum can be useful?
            each position = sum + all previous position
            subarray sum = end - start
            min(end - start)
        -> at each position, it's either starting a new bucket, or adding to existing bucket
            if # bucket < k, then you can add a new bucket starting next element
            if # bucket >= k, then you can only expand
            -> sounds like dp knapsack / accumulation? (probably will try this first)
        */
        int n = nums.length;
        memo = new Integer[n][k];
        int min = helper(nums, k, 0, 0);
        
        return min;
    }

    public int helper(int[] nums, int k, int i, int bucketCount){
        if(i >= nums.length) {
            if(k == bucketCount) return 0;
            return Integer.MAX_VALUE;
        }
        if(k == bucketCount) return Integer.MAX_VALUE;
        if(memo[i][bucketCount] != null) return memo[i][bucketCount];

        int res = Integer.MAX_VALUE;
        int curTotal = 0;
        for(int j = i; j <= nums.length - (k - bucketCount); j++){

            // keep one bucket
            curTotal += nums[j];

            // create a new bucket
            int curMax = Math.max(curTotal, helper(nums, k, j+1, bucketCount + 1));

            res = Math.min(res, curMax);
        }
        memo[i][bucketCount] = res;

        return res;
    }
}








