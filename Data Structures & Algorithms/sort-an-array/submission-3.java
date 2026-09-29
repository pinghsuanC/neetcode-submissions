class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right){
        if(right <= left){
            if(left == right && nums[left] > nums[right]) swap(nums, left, right);
            return;
        }

        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex+1, right);
    }

    public int partition(int[] nums, int left, int right){
        // use a simple ver for now
        int pivot = nums[right];
        int i = left;
        
        for(int j = left; j < right; j++){
            if(nums[j] < pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}