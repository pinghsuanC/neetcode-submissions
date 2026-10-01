class Solution {
    public boolean search(int[] nums, int target) {
        /*
        intuition: 
        binary search with special checks on where the mid point is
        start with l = 0, r = len - 1;
        - check which part is sorted and which part we eliminate
            (you have to have a half that is sorted, either on left or right)
        - if nums[l] == nums[m], increment l to eliminate duplicates

        while l <= r
            m = (l + r) / 2
            if nums[m] == target, return true
            if nums[l] == nums[m], l++ and continue (same values)

            if nums[l] < nums[m] -> it means we are in the left portion
                see which half we abandon
                -> nums[m] > target && nums[l] <= target (target in left part)
                    r = m - 1
                -> else, it's in the left, l = m+1
            else -> in the right portion
                -> nums[m] < target && nums[r] >= target (target in the right part)
                    l = m+1
                -> else, r = m-1

        return fasle if not found
        */

        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] == target) return true;
            if(nums[l] == nums[m]) {
                l++;
                continue;
            }

            if(nums[l] < nums[m]){
                // left portion
                if(nums[l] <= target && target < nums[m]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if(nums[m] < target && target <= nums[r]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return false;
    }
}