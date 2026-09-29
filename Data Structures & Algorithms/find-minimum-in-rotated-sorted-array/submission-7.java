class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, min = nums[0];
        while(l < r){
            int m = (r - l) / 2 + l;
            min = Math.min(min, nums[m]);
            if(nums[m] >= nums[r]){
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}
