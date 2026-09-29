class Solution {
    public int maxSubArray(int[] nums) {
        int res = 0, max = nums[0];

        for(int n : nums){
            res = Math.max(n, res + n);
            max = Math.max(res, max);
        }

        return max;
    }
}
