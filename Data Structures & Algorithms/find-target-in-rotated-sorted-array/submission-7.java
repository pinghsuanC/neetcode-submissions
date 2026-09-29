class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(target == nums[m]) return m;
            // check which side is in ascending order
            if(nums[m] >= nums[l]){
                // left side is ascending
                if(target < nums[m] && target >= nums[l]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // right side is ascending
                if(target > nums[m] && target <= nums[r]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
