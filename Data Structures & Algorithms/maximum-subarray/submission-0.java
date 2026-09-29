class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0,
            maxSum = nums[0];

        for(int i = 0; i < nums.length; i++){
            curSum = Math.max(curSum, 0);
            curSum += nums[i];
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }
}
