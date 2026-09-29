class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            System.out.println(m + " " + nums[m]);
            System.out.println(l);
            if(target == nums[m]) return m;
            if(nums[l] < nums[r]){
                // case where it's ascending
                if(target < nums[m]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // case where it's rotated
                if(nums[m] < nums[l]){
                    // first half contains the pivot
                    if(target < nums[m]){
                        // must be in the first half
                        r = m - 1;
                    } else {
                        // target > nums[m], either in second half, or in first half before the pivot
                        // this will depends on value of nums[l]
                        if(nums[l] <= target){
                            r = m - 1;
                        } else {
                            l = m + 1;
                        }
                    }
                } else {
                    // first half ascending, second part has the pivot
                    if(target < nums[m]){
                        // answer is in either the first part or the second part depending on nums[r]
                        if(target > nums[r]){
                            // answer is in the first half
                            r = m - 1;
                        } else {
                            // answer is in the second half
                            l = m + 1;
                        }
                    } else {
                        // target > nums[m]
                        // it must be in the second half
                        l = m + 1;
                    }
                }
            }
            
        }
        return -1;
    }
}
