class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;
        k%=n;
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[]nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}