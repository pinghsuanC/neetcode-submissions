class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] outputs = new int[nums.length];

        int[] arr1 = new int[nums.length];
        int prod = 1;
        for(int i = 0; i < nums.length; i++){
            arr1[i] = prod;
            prod*=nums[i];
        }
        
        int[] arr2 = new int[nums.length];
        prod = 1;
        for(int i = nums.length - 1; i>=0; i--){
            arr2[i] = prod;
            prod*=nums[i];
        }

        for(int i = 0; i<nums.length; i++){
            outputs[i] = arr1[i] * arr2[i];
        }
        
        return outputs;
    }
}  
