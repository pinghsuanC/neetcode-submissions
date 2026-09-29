class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        helper(nums, output, 0, 1);
        return output;
    }

    public int helper(int[] nums, int[] output, int i, int acc){
        if(i == nums.length - 1){
            int val = acc * nums[i];
            output[i] = acc;
            return nums[i];
        }
        if(i < nums.length){ 
            int returned = helper(nums, output, i+1, nums[i]*acc);
            output[i] = returned * acc;
            return returned*nums[i];
        }
        return -1;
    }
}  
