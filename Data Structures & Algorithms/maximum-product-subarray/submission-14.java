class Solution {
    public int maxProduct(int[] nums) {
        /*
        using prefix sum & suffix sum method
        it's the same as the kaden's algorithm
        */

        int prefix = 1, suffix = 1, res = nums[0];

        for(int i = 0; i < nums.length; i++){
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[nums.length - i  - 1] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, Math.max(prefix, suffix));
        }

        return res;
    }
}
