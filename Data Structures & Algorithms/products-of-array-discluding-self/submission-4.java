class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prod1 = new int[n];
        int[] prod2 = new int[n];
        int[] res = new int[n];

        int prod = 1;
        for(int i = 0; i<nums.length; i++){
            prod1[i] = prod;
            prod*=nums[i];
        }

        prod = 1;
        for(int i = nums.length-1; i >=0; i--){
            prod2[i] = prod;
            prod*=nums[i];
        }

        for(int i = 0; i<n; i++){
            res[i] = prod1[i] * prod2[i];
        }

        return res;
    }
}  
