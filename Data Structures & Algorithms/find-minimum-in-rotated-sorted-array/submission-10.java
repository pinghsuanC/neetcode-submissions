class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        int l = 0, r = nums.length - 1, min = nums[0];
        //if(nums[r] > nums[l]) return nums[l];
        while(l < r){
            int m = l + (r - l) / 2 + 1;
            min = Math.min(min, nums[m]);
            if(nums[m] > nums[l]){
                l = m + 1;
                if(l >= nums.length) break;
                min = Math.min(min, nums[l]);
            } else {
                r = m - 1;
            }
        }
        return min;
    }
}
