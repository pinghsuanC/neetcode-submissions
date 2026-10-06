class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;

        int l = 0, r = 0;
        while(r < n){
            nums[l] = nums[r];
            while(r < n && nums[r] == nums[l]){
                r++;
            }
            l++;
        }
        return l;
    }

    private void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}