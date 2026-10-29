class Solution {
    public int firstMissingPositive(int[] nums) {
        /*
        intuition: 
        get the largest positive integer
        and cascadingly search for the smaller one

        if reached 0, we don't have any in range smaller than max, it has to be largest positive integer + 1


        same intuition, but compress the hashtable into the original array to reduce space complexity
        
        */


        int n = nums.length;
        int i = 0;

        while(i < n){
            if(nums[i]<=0 || nums[i] > n){
                i++;
                continue;
            }
            int index = nums[i] - 1;
            if(nums[i] != nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            } else {
                i++;
            }
        }

        for(int j = 0; j < n; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }

        return n+1;
    }
}