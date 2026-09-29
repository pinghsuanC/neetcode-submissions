class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        int l = 0, r = nums.length - 1, min = nums[0];
        while(l <= r){
            if(nums[r] > nums[l]){
                min = Math.min(min, nums[l]);
                break;
            }
            int m = l + (r - l) / 2;
            min = Math.min(min, nums[m]);
            if(nums[m] >= nums[l]){
                min = Math.min(nums[l], min);
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return min;
    }
}
