class Solution {
    public int maxSubArray(int[] nums) {
        int max = 0, res = nums[0];

        for(int n : nums){
            max = Math.max(n, n + max);
            res = Math.max(res, max);
        }

        return res;
    }
}
