class Solution {
    public boolean canJump(int[] nums) {
        
        int goal = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= goal) goal = i;
        }

        return goal == 0;
    }

    private boolean helper(int[] nums, int i){
        if(i == nums.length - 1) return true;

        for(int j = Math.min(nums[i] + i, nums.length - 1); j >= 0; j--){
            if(helper(nums, j+i)) return true;
        }

        return false;
    }
}
