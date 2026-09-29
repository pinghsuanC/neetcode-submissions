class Solution {
    public int maxSubArray(int[] nums) {
        
        int curMax = nums[0], curSum = 0;
        for(int n : nums){
            curSum = Math.max(n, n + curSum);
            curMax = Math.max(curMax, curSum);
        }

        return curMax;
    }
}
