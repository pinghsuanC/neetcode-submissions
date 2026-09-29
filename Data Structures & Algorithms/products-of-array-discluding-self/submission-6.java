class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] outputs = new int[nums.length];

        int[] arr1 = new int[nums.length];
        int prod = 1;
        arr1[0] = 1;
        for(int i = 1; i < nums.length; i++){
            prod*=nums[i-1];
            arr1[i] = prod;
        }
        
        int[] arr2 = new int[nums.length];
        prod = 1;
        arr2[nums.length - 1] = 1;
        for(int i = nums.length - 2; i>=0; i--){
            prod*=nums[i+1];
            arr2[i] = prod;
        }

        for(int i = 0; i<nums.length; i++){
            outputs[i] = arr1[i] * arr2[i];
        }
        
        return outputs;
    }
}  
