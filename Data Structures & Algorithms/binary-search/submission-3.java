class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int k = (r - l)/2 + l;
            if(nums[k] < target){
                l = k + 1;
            } else if (nums[k] > target){
                r = k - 1;
            } else {
                return k;
            }
        }
        return -1;
    }
}
