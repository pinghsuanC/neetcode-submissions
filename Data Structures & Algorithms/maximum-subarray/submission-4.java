class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, curSum = nums[n - 1], res = nums[n - 1];

        for(int i = nums.length - 2; i >= 0; i--){
            curSum = Math.max(nums[i], curSum+nums[i]);
            res = Math.max(res, curSum);
        }

        return res;
    }
}
