class Solution {
    public int maxProduct(int[] nums) {
        /*
        intuition: the max product is either a prefix, or a suffix of an element
                maximuze the prefix / suffix, we got the result
        */

        int res = nums[0], prefix = 1, suffix = 1;

        for(int i = 0; i < nums.length; i++){
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[nums.length - i - 1] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, Math.max(prefix, suffix));
        }

        return res;
    }
}
