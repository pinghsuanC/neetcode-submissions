class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = nums[0], curSum = 0;
        for(int n : nums){
            // either itself is largest & starts a new subarray
            // or need to continue the legacy array
            // if cur sum is negative, i'd rather start over
            if(curSum < 0) curSum = 0;
            curSum += n;
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
