class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] outputs = new int[nums.length];
        helper(nums, outputs, 0, 1);
        return outputs;
    }

    public int helper(int[] nums, int[] outputs, int i, int acc){
        if(i < nums.length - 1){
            int returned = helper(nums, outputs, i+1, acc*nums[i]);
            int val = returned * acc;
            outputs[i] = val;
            return returned * nums[i];
        }else{
            int val = acc;
            outputs[i] = val;
            return nums[i];
        }
    }
}  
