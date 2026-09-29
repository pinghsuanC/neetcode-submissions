class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            System.out.println(m + " " + nums[m]);
            System.out.println(l);
            if(target == nums[m]) return m;
            // check which side is sorted, and go from there
            
            if(nums[l] <= nums[m]){
                if(target > nums[m] || target < nums[l]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if(target < nums[m] || target > nums[r]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
