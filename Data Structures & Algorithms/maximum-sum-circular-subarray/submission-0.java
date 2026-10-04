class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        // brute forcely apply the maxSum algorithm
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(helper(nums, i), res);
        }
        
        return res;
    }

    public int helper(int[] nums, int start){
        int curSum = 0, max = nums[0], n = nums.length;
        for(int i = start; i < start + n; i++){
            if(curSum < 0) curSum = 0;
            curSum += nums[i % n];
            max = Math.max(max, curSum);
        }
        return max;
    }
}