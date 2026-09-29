class Solution {
    public int[] sortArray(int[] nums) {
        boolean swapped = true;
        int n = nums.length;
        while(swapped){
            swapped = false;
            for(int k = 0; k < n - 1; k++){
                if(nums[k] > nums[k+1]){
                    swap(nums, k, k+1);
                    swapped = true;
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