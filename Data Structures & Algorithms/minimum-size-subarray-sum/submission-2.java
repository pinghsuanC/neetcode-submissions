class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        /*
        intuition: all positive
        we may have multiple subarrays that is summing up to target
        
        starting from l = 0 r = 1
        sum = nums[0];
        loop until l == r && r < n - 1
        r++ first, update sum with nums[r]
        if > target, move l to right
        if < target, expand r to r+1
        if == targer, record length
            given that the sum of l to r == 10, in this case expending r alone will only result in a sum > target, so move l to next step too
        
        return min length
        */

        int l = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        if(sum >= target) return 1; // there can't be anything smaller than this
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while(sum >= target){
                res = Math.min(res, r - l + 1);
                sum-=nums[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}