class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, res = nums[0];

        for(int n : nums){
            curSum = Math.max(n, curSum + n);
            res = Math.max(res, curSum);
        }

        return res;
    }
}
