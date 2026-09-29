class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, min = nums[l];
        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] > nums[r]){
                // find min in the second half
                l = m + 1;
                min = Math.min(min, nums[r]);
            } else {
                // find min in the frist half
                r = m - 1;
                min = Math.min(min, nums[m]);
            }
        }

        return min;
    }
}
