class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;

        int l = 0, r = 1;
        while(r < n){
           if(nums[r] <= nums[l]){
                int nextIndex = r;
                while(nextIndex < n && nums[nextIndex] <= nums[l]){
                    nextIndex++;
                }
                if(nextIndex == n) return r;
                int tmp = nums[r];
                nums[r] = nums[nextIndex];
                nums[nextIndex] = tmp;
           }
           l++;
           r++;
        }

        return r;
    }
}