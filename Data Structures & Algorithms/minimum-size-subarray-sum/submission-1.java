class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int total = Arrays.stream(nums).sum();
        int n = nums.length;
        if(total < target) return 0;
        if(total == target) return n;

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

        int l = 0, r = 1;
        int sum = nums[l];
        int res = Integer.MAX_VALUE;
        if(sum >= target) return 1; // there can't be anything smaller than this
        sum+=nums[r];
        while(r <= n - 1){
            if(sum < target){
                r++;
                if(r > n-1) break;
                sum+=nums[r];
            } else {
                // sum >= target, can try to shrink l
                // System.out.println("l, r, sum:" + l + " " + r + " " + sum);
                res = Math.min(res, (r - l + 1));
                sum-=nums[l];
                l++;
            }
        }

        return res;
    }
}