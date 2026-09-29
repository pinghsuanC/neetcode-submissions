class Solution {
    public int maxSubArray(int[] nums) {
        /*
        testing the prefix / suffix sum
        */

        int res = nums[0], prefix = 0, suffix = 0;
        for(int i = 0; i < nums.length; i++){
            prefix = nums[i] + (prefix < 0 ? 0 : prefix);
            res = Math.max(res, prefix);
        }

        return res;
    }
}
