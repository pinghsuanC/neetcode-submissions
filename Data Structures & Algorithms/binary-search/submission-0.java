class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }
    public int helper(int[] nums, int target, int l, int r){
        int m = l + (r - l)/2;
        if(l > r){ return -1; }
        if(nums[m] == target){ return m;}
        if(nums[m] < target){
            return helper(nums, target, m+1, r);
        } else {
            return helper(nums, target, l, m-1);
        }
    }
}
