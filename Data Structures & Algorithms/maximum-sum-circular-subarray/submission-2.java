class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /*
        two cases:
        1. subarray wrap around
        2. it's in the middle somewhere
        
        */
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        int suffixSum = nums[n - 1];

        // for non-wrapping case, apply the maxSum algo
        int max = nums[0], middleSum = 0;
        for(int k : nums){
            if(middleSum < 0) middleSum = 0;
            middleSum += k;
            max = Math.max(max, middleSum);
        }

        // for the wrapping case, find the best prefix sum
        for(int i = n - 2; i >= 0; i--){
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i+1], suffixSum);
        }

        int prefixSum = 0, prefixMaxSum = nums[0];
        for(int i = 0; i < n; i++){
            prefixSum+=nums[i];
            if(i + 1 < n){
                prefixMaxSum = Math.max(prefixSum + rightMax[i + 1], prefixMaxSum);
            }
        }

        return Math.max(prefixMaxSum, max);
    }
}