class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] == target) return m;
            
            // check which part is sorted
            if(nums[l] <= nums[m]){
                // left part is sorted, check if target is in there
                if(nums[m] > target && nums[l] <= target){
                    // in there
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // right part is sorted, check if target is in there
                if(nums[m] < target && nums[r] >= target){
                    // in there
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        
        }

        return -1;
    }
}
