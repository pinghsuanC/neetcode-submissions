class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        helper(nums, output, 0, 1, 1);
        return output;
    }

    public int helper(int[] nums, int[] output, int i, int acc, int acc2){
        if(i == nums.length - 1){
            int val = acc * nums[i];
            output[i] = acc;
            acc2 = nums[i];
            return acc2;
        }
        if(i < nums.length){ 
            int returned = helper(nums, output, i+1, nums[i]*acc, 1);
            output[i] = returned * acc;
            return returned*nums[i];
        }
        return -1;
    }
}  
