class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0],
            curMax = 1, curMin = 1;

        for(int n : nums){
            int tmp = curMax * n;
            curMax = Math.max(Math.max(n, n * curMax), n * curMin);
            curMin = Math.min(Math.min(n, tmp), n * curMin);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
