class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1, curMin = 1, res = nums[0];

        for(int n : nums){
            int tmp = curMax * n;
            curMax = Math.max(n, Math.max(tmp, curMin * n));
            curMin = Math.min(n, Math.min(tmp, curMin * n));
            res = Math.max(curMax, res);
        }

        return res;
    }
}
