class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            System.out.println(m + " " + nums[m]);
            System.out.println(l);
            if(target == nums[m]) return m;
            if(nums[l] <= nums[m]){
                if(target > nums[m] || target < nums[l]){
                    // must be in the first half
                    l = m + 1;
                } else {
                    // target > nums[m], either in second half, or in first half before the pivot
                    // this will depends on value of nums[l]
                    r = m - 1;
                }
            } else {
                // first half ascending, second part has the pivot
                if(target < nums[m] || target > nums[r]){
                    // answer is in either the first part or the second part depending on nums[r]
                    r = m - 1;
                } else {
                    // target > nums[m]
                    // it must be in the second half
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
