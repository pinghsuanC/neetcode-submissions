class Solution {
    public int findDuplicate(int[] nums) {
        for(int n : nums){
            int i = Math.abs(n) - 1;
            if(nums[i] < 0){
                return Math.abs(n);
            }
            nums[i] *= -1;
        }
        return -1;
    }
}
