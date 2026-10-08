class Solution {
    public void sortColors(int[] nums) {
        
        int n = nums.length, l = 0, r = n - 1;
        
        for(int i = 0; i <= 2; i++){
            // make sure nums[l] is not the target
            while(l < n && nums[l] == i) {
                l++;
            }
            r = l + 1;
            // use r to scan the array
            while(r < n){
                if(nums[r] == i){
                    swap(nums, l, r);
                    l++;
                }
                r++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }
}