class Solution {
    public int[] sortArray(int[] nums) {
        int pass = 1;
        int n = nums.length;
        while(pass > 0){
            pass = 0;
            for(int k = 0; k < n - 1; k++){
                if(nums[k] > nums[k+1]){
                    swap(nums, k, k+1);
                    pass++;
                }
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}