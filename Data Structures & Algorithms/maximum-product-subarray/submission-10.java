class Solution {
    public int maxProduct(int[] nums) {
        /*
        notes

        define dp[i] as the maximun product you can have by using elements from 0 to i
        at each position i, there are a few things to be decided / compared
        -> num[i]
        -> num[i] * max product so far

        However, given that there are negavies and zeros in the array
        notice when it's a negative, it's possinle to invert the signs and make another maximun

        therefore we need to track the minimun as well 

        */

        int curMax = 1, curMin = 1, res = nums[0];

        for(int n : nums){
            int tmp = n * curMax;
            curMax = Math.max(n, Math.max(n * curMax, n * curMin));
            curMin = Math.min(n, Math.min(tmp, n * curMin));
            res = Math.max(res, curMax);
        }

        return res;
    }
}
