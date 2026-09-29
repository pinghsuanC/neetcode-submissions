class Solution {
    public int maxSubArray(int[] nums) {
        /*
        testing the prefix / suffix sum
        */

        int res = nums[0], prefix = 0, suffix = 0;
        for(int i = 0; i < nums.length; i++){
            prefix = nums[i] + (prefix < 0 ? 0 : prefix);
            suffix = nums[nums.length - i - 1] + (suffix < 0 ? 0 : suffix);
            res = Math.max(Math.max(prefix, suffix), res);
        }

        return res;
    }
}
