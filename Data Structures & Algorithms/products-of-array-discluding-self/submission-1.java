class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countZero = 0;
        int prod = 1;
        for(int n : nums){
            if(n == 0){
                countZero++;
            } else {
                prod *= n;
            }
        }

        int[] res = new int[nums.length];
        if(countZero > 1){
            for(int i = 0; i<nums.length; i++){
                res[i] = 0;
            }
        } else if(countZero == 1){
            for(int i = 0; i<nums.length; i++){
                if(nums[i] == 0){
                    res[i] = prod;
                } else {
                    res[i] = 0;
                }
            }
        } else {
            for(int i = 0; i<nums.length; i++){
                res[i] = prod/nums[i];
            }
        }

        return res;
    }
}  
